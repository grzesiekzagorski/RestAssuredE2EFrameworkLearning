package api.test;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpointsFromProperties;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests {

    private  Faker faker;
    private User userPayload;

    public Logger logger;


    @BeforeClass
    public void setupData(){
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser(){

        logger.info("Creating user");
        Response response = UserEndpointsFromProperties.createUser(userPayload);
        response.then()
                .statusCode(200)
                .log().all();

        logger.info("User is created");
    }

    @Test(priority = 2)
    public void testGetUserByName(){
        logger.info("Reading user info");
        Response response = UserEndpointsFromProperties.readUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("User is displayed");
    }

    @Test(priority = 3)
    public void testUpdateUser(){

        logger.info("Updating user");
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        Response response = UserEndpointsFromProperties.updateUser(userPayload.getUsername(),userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("User is updated");
    }

    @Test(priority = 4)
    public void testDeleteUserByName(){
        logger.info("Deleting user");
        Response response = UserEndpoints.deleteUser(userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("User is deleted");
    }



}
