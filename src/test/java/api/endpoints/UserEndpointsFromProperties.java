package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndpointsFromProperties {

    private static ResourceBundle getUrl(){
        ResourceBundle routes = ResourceBundle.getBundle("routes"); //load properties file
        return routes;
    }

    public static Response createUser(User payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(getUrl().getString("post_url"));
    }

    public static Response readUser(String username) {

        return given()
                .accept(ContentType.JSON)
                .when()
                .pathParam("username", username)
                .get(getUrl().getString("get_url"));
    }

    public static Response updateUser(String username, User payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .pathParam("username", username)
                .put(getUrl().getString("get_url"));
    }

    public static Response deleteUser(String username) {

        return given()
                .accept(ContentType.JSON)
                .when()
                .pathParam("username", username)
                .delete(getUrl().getString("delete_url"));
    }
}
