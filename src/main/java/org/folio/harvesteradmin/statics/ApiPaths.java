package org.folio.harvesteradmin.statics;

public class ApiPaths
{
    // API path to this FOLIO module
    public final static String THIS_API_BASE_PATH = "/harvester-admin";

    // API path to the underlying Harvester back-end
    public final static String HARVESTER_BASE_PATH = "/harvester/records";

    public final static String THIS_ID_PATH = "/:id";

    public final static String HARVESTABLES_PATH = "/harvestables";
    public final static String STORAGES_PATH = "/storages";
    public final static String TRANSFORMATIONS_PATH = "/transformations";
    public final static String STEPS_PATH = "/steps";
    public final static String TRANSFORMATIONS_STEPS_PATH = "/tsas";
    public final static String LOG_PATH = "/log";

    // FOLIO harvester-admin APIs
    public final static String THIS_HARVESTABLES_PATH = THIS_API_BASE_PATH + HARVESTABLES_PATH;
    public final static String THIS_HARVESTABLES_ID_PATH = THIS_API_BASE_PATH + HARVESTABLES_PATH + THIS_ID_PATH;
    public final static String THIS_HARVESTABLES_LOG_PATH = THIS_API_BASE_PATH + HARVESTABLES_PATH + THIS_ID_PATH + LOG_PATH;
    public final static String THIS_STORAGES_PATH = THIS_API_BASE_PATH + STORAGES_PATH;
    public final static String THIS_STORAGES_ID_PATH = THIS_API_BASE_PATH + STORAGES_PATH + THIS_ID_PATH;
    public final static String THIS_TRANSFORMATIONS_PATH = THIS_API_BASE_PATH + TRANSFORMATIONS_PATH;
    public final static String THIS_TRANSFORMATIONS_ID_PATH = THIS_API_BASE_PATH + TRANSFORMATIONS_PATH + THIS_ID_PATH;
    public final static String THIS_STEPS_PATH = THIS_API_BASE_PATH + STEPS_PATH;
    public final static String THIS_STEPS_ID_PATH = THIS_API_BASE_PATH + STEPS_PATH + THIS_ID_PATH;
    public final static String THIS_TRANSFORMATIONS_STEPS_PATH = THIS_API_BASE_PATH + TRANSFORMATIONS_STEPS_PATH;
    public final static String THIS_TRANSFORMATIONS_STEPS_ID_PATH = THIS_API_BASE_PATH + TRANSFORMATIONS_STEPS_PATH + THIS_ID_PATH;

    // Legacy Harvester APIs
    public final static String HARVESTER_HARVESTABLES_PATH = HARVESTER_BASE_PATH + HARVESTABLES_PATH;
    public final static String HARVESTER_STORAGES_PATH = HARVESTER_BASE_PATH + STORAGES_PATH;
    public final static String HARVESTER_TRANSFORMATIONS_PATH = HARVESTER_BASE_PATH + TRANSFORMATIONS_PATH;
    public final static String HARVESTER_STEPS_PATH = HARVESTER_BASE_PATH + STEPS_PATH;
    public final static String HARVESTER_TRANSFORMATIONS_STEPS_PATH = HARVESTER_BASE_PATH + TRANSFORMATIONS_STEPS_PATH;

    // Run jobs
    public final static String RUN_JOB = "/jobs/run";
    public final static String STOP_JOB = "/jobs/stop";
    public final static String THIS_RUN_JOB_ID_PATH = THIS_API_BASE_PATH + RUN_JOB + THIS_ID_PATH;
    public final static String THIS_STOP_JOB_ID_PATH = THIS_API_BASE_PATH + STOP_JOB + THIS_ID_PATH;

    // XSLT scripts
    public final static String THIS_SCRIPT_PATH = "/script";
    public final static String THIS_STEPS_ID_SCRIPT_PATH = THIS_STEPS_ID_PATH + THIS_SCRIPT_PATH;

}
