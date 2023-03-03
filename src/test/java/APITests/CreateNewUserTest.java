package APITests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.BaseData;
import utils.Tools;
import utils.User;

import static io.restassured.RestAssured.given;



public class CreateNewUserTest extends BaseData {

    @Test
    public void createNewUser () {
        User user = new User();
        user.setName("Anthony");
        user.setJob("Driver");

      Response response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("users")
                .then()
                .extract().response();
      Tools.responseValueAssertion(response, "name", "Anthony");
      Tools.responseValueAssertion(response, "job", "Driver");
      Tools.responseStatusCodeAssertion(response, 201);
    }
}
