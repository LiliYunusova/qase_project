package adapters;

import io.restassured.response.Response;
import models.Project;

public class ProjectAdapter extends adapters.BaseAdapter {

    private static final String PROJECT_API_ENDPOINT = "/project";

    public Response getProjects() {
        return get(PROJECT_API_ENDPOINT);
    }

    public Response create(Project project) {
        return post(PROJECT_API_ENDPOINT, converter.toJson(project));
    }
}
