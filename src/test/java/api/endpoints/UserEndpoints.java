package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoints {


    public static Response createUser(User payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
    }

    public static Response readUser(String username) {

        return given()
                .accept(ContentType.JSON)
                .when()
                .pathParam("username", username)
                .get(Routes.get_url);
    }

    public static Response updateUser(String username, User payload) {

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .pathParam("username", username)
                .put(Routes.update_url);
    }

    public static Response deleteUser(String username) {

        return given()
                .accept(ContentType.JSON)
                .when()
                .pathParam("username", username)
                .delete(Routes.delete_url);
    }


}
