package adapters;

import io.restassured.response.Response;
import models.Suite;

public class SuiteAdapter extends adapters.BaseAdapter {

    private static final String SUITE_API_ENDPOINT = "/suite/%s";
    private static final String SUITE_API_ENDPOINT_ID = "/suite/%s/%s";

    public Response getSuite(String projectCode){
        return get(String.format(SUITE_API_ENDPOINT,projectCode));
    }

    public Response create(String projectCode, Suite suite) {
        return post(String.format(SUITE_API_ENDPOINT, projectCode), converter.toJson(suite));
    }

    public Response update(String projectCode, int id, Suite suite){
        return patch(String.format(SUITE_API_ENDPOINT_ID,projectCode, id),converter.toJson(suite));
    }

    public Response delete(String projectCode, int id, Suite suite){
        return delete(String.format(SUITE_API_ENDPOINT_ID,projectCode, id),converter.toJson(suite));
    }


}
