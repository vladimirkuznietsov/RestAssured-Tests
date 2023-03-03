package APITests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseData;
import utils.Tools;
import utils.User;

import static io.restassured.RestAssured.given;

public class SuccessfulUserRegistrationTest extends BaseData {

    @Test
    public void registerUser () {
        User user = new User();
        user.setEmail("eve.holt@reqres.in");
        user.setPassword("pistol");

       Response response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("register")
                .then()
                .extract().response();
       Tools.responseStatusCodeAssertion(response, 200);
       Tools.responseKeyAssertion(response, "id");
       Tools.responseKeyAssertion(response, "token");
    }
}
