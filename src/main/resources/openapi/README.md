# Building and checking the `mod-harvester-admin` OpenAPI specification

## Building

To reduce repetition, [the OpenAPI YAML file](harvester-admin-0.1.yaml) is generated using [the m4 macro processor](https://www.gnu.org/software/m4/). The YAML file should therefore not be edited directly: instead [the template file](harvester-admin-0.1.yaml.m4) should be edited and the YAML regenerated using `make`.

To simplify the build process, we check in the generated file as well as the source: some operating systems may not come with m4 or have a simple way to install it.

## Checking

[The `Makefile`](Makefile) provides four targets that can be used to check the correctness of the OpenAPI specification and its associated JSON Schemas:
* `schemalint` checks the JSON schemas using [AJV](https://ajv.js.org/)
* `examplelint` checks that the example records conform to the appropriate schemas
* `apilint` checks the API file using [FOLIO's api-lint](https://github.com/folio-org/folio-tools/tree/master/api-lint)
* `lint` runs all threee of these checks

The AJV command-lint client can be installed using `npm -g install ajv-cli`.

FOLIO's api-lint is a little more complicated to install:

	$ git clone https://github.com/folio-org/folio-tools
	$ cd folio-tools/api-lint
	$ yarn install
	$ pip3 install -r requirements.txt
	// ... and symbolically link folio-tools/api-lint/api_lint.py somewhere on the path

## Generating documentation

The `Makefile` provides a `doc` target that can be used to generate human-readable documentation from the OpenAPI specification and its associated JSON Schemas, using [FOLIO's api-doc](https://github.com/folio-org/folio-tools/tree/master/api-doc). The documentation will be generated in [the `doc` subdirectory](doc).

FOLIO's api-doc is installed the same way was api-lint, but from `folio-tools/api-doc`.

