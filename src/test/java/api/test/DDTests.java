package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import api.utilities.EntentReportManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(EntentReportManager.class)
public class DDTests {


    @Test(priority = 1, dataProvider = "Data",dataProviderClass = DataProviders.class)
    public void testPostUser(String userId, String userName, String fName, String lName, String email,
                             String password, String phone){

        User userPayload = new User();

        userPayload.setId(Integer.parseInt(userId));
        userPayload.setUsername(userName);
        userPayload.setFirstName(fName);
        userPayload.setLastName(lName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = UserEndpoints.createUser(userPayload);
        response.then()
                .statusCode(200)
                .log().all();

    }

    @Test(priority = 2, dataProvider = "UserNames",dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName){
        Response response = UserEndpoints.deleteUser(userName);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

    }

}
