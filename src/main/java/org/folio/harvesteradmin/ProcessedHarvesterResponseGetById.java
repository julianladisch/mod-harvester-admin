package org.folio.harvesteradmin;

import io.vertx.core.AsyncResult;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.HttpResponse;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class ProcessedHarvesterResponseGetById extends ProcessedHarvesterResponse
{

    public ProcessedHarvesterResponseGetById( AsyncResult<HttpResponse<Buffer>> response, String apiPath, String id )
    {
        if ( response.succeeded() )
        {
            bodyAsString = response.result().bodyAsString();
            int harvesterStatusCode = response.result().statusCode();

            if ( harvesterStatusCode == 200 )
            {
                try
                {
                    Document doc = Xml2Json.XMLStringToXMLDocument( bodyAsString );
                    JsonObject transformed = Xml2Json.recordXml2Json( doc );
                    if ( transformed == null )
                    {
                        errorMessage = "Attempted transformation of the Harvester response [" + bodyAsString + "] failed to produce a JSON object";
                        statusCode = 500;
                    }
                    else
                    {
                        jsonObject = getRootObject( transformed );
                        if ( jsonObject == null )
                        {
                            errorMessage = "Did not find one and only one top-level object in the transformed JSON: " + transformed.encodePrettily();
                            statusCode = 500;
                        }
                        else
                        {
                            statusCode = 200;
                        }
                    }
                }
                catch ( IOException | ParserConfigurationException | SAXException e )
                {
                    jsonObject = new JsonObject();
                    errorMessage = "Could not create XML document from Harvester response [" + bodyAsString + "]";
                    statusCode = 500;
                }
            }
            else if ( notFound( harvesterStatusCode, bodyAsString ) )
            {
                statusCode = 404;
                errorMessage = apiPath + "/" + id + " not found";
            }
            else
            {
                statusCode = harvesterStatusCode;
                errorMessage = apiPath + "/" + id + " encountered error reported as (" + harvesterStatusCode + ") [" + bodyAsString + "] by the harvester";
            }
        }
        else
        {
            statusCode = 500;
            errorMessage = "GET request to " + apiPath + "/" + id + " failed with: " + response.cause().getMessage();
        }
    }

    private JsonObject getRootObject( JsonObject json )
    {
        Object[] properties = json.fieldNames().toArray();
        if ( properties.length != 1 )
        {
            return null;
        }
        else
        {
            return json.getJsonObject( properties[0].toString() );
        }
    }

    private boolean notFound( int originalStatusCode, String responseBody )
    {
        return ( originalStatusCode == 500 && responseBody.contains( "NullPointerException" ) && responseBody.contains(
                "Converter.getId(" ) );
    }

    public boolean found()
    {
        return ( statusCode == 200 );
    }

}
