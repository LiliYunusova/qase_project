package adapters;

import com.google.gson.Gson;
import io.restassured.response.Response;

import static api.utils.StringConstant.*;
import static io.restassured.RestAssured.given;


public class BaseAdapter {

    private static final String TOKEN_VALUE = "472c6f08db3766ead5ffb7d63a06878b9d206fe0111ced55e392934d993db3e8";
    private static final String BASE_URL = "https://api.qase.io/v1";
    protected Gson converter = new Gson();

    public Response get(String url) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .when()
                        .get(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    public Response post(String url, String body) {
        return
                given()
                        .header(TOKEN_NAME, TOKEN_VALUE)
                        .header(CONTENT_TYPE, JSON)
                        .body(body)
                        .when()
                        .post(BASE_URL + url)
                        .then()
                        .log().all()
                        .extract().response();
    }

    public Response patch(String url, String body) {
        return given()
                .header(TOKEN_NAME, TOKEN_VALUE)
                .header(CONTENT_TYPE, JSON)
                .body(body)
                .when()
                .patch(BASE_URL + url)
                .then()
                .log().all()
                .extract().response();
    }

    public Response delete(String url, String body) {
        return given()
                .header(TOKEN_NAME, TOKEN_VALUE)
                .header(CONTENT_TYPE, JSON)
                .body(body)
                .when()
                .delete(BASE_URL + url)
                .then()
                .log().all()
                .extract().response();
    }
}
