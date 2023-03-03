package utils;

import io.restassured.response.Response;
import org.testng.Assert;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;

public class Tools {

    public static void responseValueAssertion(Response response, String key, String value) {
        Assert.assertEquals(response.jsonPath().getString(key), value);
    }

    public static void responseStatusCodeAssertion (Response response, int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }

    public static void responseKeyAssertion (Response response, String key) {
        Assert.assertTrue(response.getBody().asString().contains(key));
    }

    public static void numberOfRecordsAssertion(Response response, String key, int size) {
        Assert.assertEquals(response.getBody().jsonPath().getList(key).size(), size);
    }

}
