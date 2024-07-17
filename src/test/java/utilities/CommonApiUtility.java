package utilities;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class CommonApiUtility {

    public Response request(String baseURI, String endPoint, Map<String, ?> header, JsonObject payload, Map<String, ?> queryParams, Method requestMethod) {
        RequestSpecification request = RestAssured.given().baseUri(baseURI).basePath(endPoint);
        if (header != null) request.headers(header);
        if (payload != null) {
            request.contentType(ContentType.JSON);
            request.body(payload);
        }
        if (queryParams != null) request.queryParams(queryParams);

        return request.request(requestMethod);
    }
}
