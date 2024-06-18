package api.endpoints;

/**
 *
 Create user(Post) : https://petstore.swagger.io/v2/user
 Get user (Get): https://petstore.swagger.io/v2/user/{username}
 Update user (Put) : https://petstore.swagger.io/v2/user/{username}
 Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}
 */


public class Routes {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static String post_url = BASE_URL + "/user";
    public static String get_url = BASE_URL + "/user/{username}";
    public static String update_url = BASE_URL + "/user/{username}";
    public static String delete_url = BASE_URL + "/user/{username}";




}
