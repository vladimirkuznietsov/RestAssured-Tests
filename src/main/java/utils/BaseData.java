package utils;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseData {
    @BeforeClass
    public static void setUp () {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/";
    }
}
