package adapters;

import io.restassured.response.Response;
import models.Cases;

public class CaseAdapter extends adapters.BaseAdapter {

    private static final String CASE_API_ENDPOINT = "/case/%s";

    public Response getCases(String projectCode){
        return  get(String.format(CASE_API_ENDPOINT, projectCode));
    }

    public Response create(String projectCode, Cases cases){
        return post(String.format(CASE_API_ENDPOINT,projectCode),converter.toJson(cases));
    }


}
