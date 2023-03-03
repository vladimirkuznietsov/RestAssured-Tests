package APITests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.BaseData;
import utils.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class VerifyTheNumberOfUsersTest extends BaseData {

    @Test
    public void getListUsers () {
       Response response =  given()
                .when()
                .get("users?page=2")
                .then()
                .extract().response();
        Tools.numberOfRecordsAssertion(response, "data.id", 6);


    }
}
