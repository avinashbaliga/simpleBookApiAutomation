package pages;

import com.google.gson.JsonObject;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.CommonApiUtility;
import utilities.JsonHandle;
import utilities.ReadProperty;

import java.util.HashMap;
import java.util.Map;

public class AuthApi extends CommonApiUtility {

    private String baseUri;

    public AuthApi() {
        baseUri = ReadProperty.get("baseUri");
    }

    //The response body will contain the access token. The access token is valid for 7 days.

    public Response getListOfBooks() {
        String endPoint = ReadProperty.get("listOfBooksEndPoint");
        return request(baseUri, endPoint, null, null, null, Method.GET);
    }

    public void verifyResponseIsNotNull(Response response) {
        Assert.assertNotSame("", response.getBody().asString());
        Assert.assertNotSame(" ", response.getBody().asString());
        Assert.assertNotSame(null, response.getBody().asString());

        //Below line is only for practice. In a production framework, always use log
        System.out.println(response.asString());
    }

    public Response submitOrder() {
        //get endpoint/basepath
        String endPoint = ReadProperty.get("submitOrderEndPoint");

        //construct payload
        JsonObject payload = (JsonObject) JsonHandle.getJsonPayload("submitOrder");
        //Here, if needed, we can update the payload as shown below
        //payload.addProperty("bookId", 2);

        //construct header
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + ReadProperty.get("token"));

        return request(baseUri, endPoint, header, payload, null, Method.POST);
    }
}
