package test.automation.pages.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

@Component("test.automation.pages.api.PostMethod")
public class PostMethod {
    private static String baseUri = "https://jsonplaceholder.typicode.com/";

    private static String title = "recomendation";
    private static String body = "motorcycle";
    private static int userId = 12;

    public Map<String, Object> dataPayload() {
        Map<String, Object> payload = new HashMap<>();

        payload.put("title", title);
        payload.put("body", body);
        payload.put("userId", userId);

        payload.values().removeAll(Collections.singleton(null));
        return payload;
    }

    public Response sendPostHttpRequest() {
        return RestAssured.given().
                when()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(dataPayload())
                .post("/posts");
    }

    public void validateHttpResponseCode201() {
        sendPostHttpRequest().then().assertThat().statusCode(201);
    }

    public void validateResponseBody() {
        sendPostHttpRequest().then().assertThat()
                .body("title", equalToIgnoringCase(title))
                .body("body", equalToIgnoringCase(body))
                .body("userId", equalTo(userId));
    }
}
