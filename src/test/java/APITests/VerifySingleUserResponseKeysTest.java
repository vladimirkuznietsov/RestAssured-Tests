package APITests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseData;
import utils.Tools;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class VerifySingleUserResponseKeysTest extends BaseData {

    @Test
    public void verifySingleUserResponseKeys () {
       Response response =  given()
                                .get("users/2")
                                .then()
                                .extract().response();
       Tools.responseStatusCodeAssertion(response, 200);
       Tools.responseKeyAssertion(response, "id");
       Tools.responseKeyAssertion(response, "email");
       Tools.responseKeyAssertion(response, "first_name");
       Tools.responseKeyAssertion(response, "last_name");
       Tools.responseKeyAssertion(response, "avatar");

    }
}
