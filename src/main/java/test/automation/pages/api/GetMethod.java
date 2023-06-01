package test.automation.pages.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

@Component("test.automation.pages.api.GetMethod")
public class GetMethod {
    private static String baseUri = "https://jsonplaceholder.typicode.com/";

    public String setApiEndpoint() {
        return baseUri + "posts";
    }

    public Response sendGetHttpRequest() {
        return RestAssured.given()
                .when()
                .get(setApiEndpoint());
    }

    public void validateHttpResponseCode200() {
         sendGetHttpRequest().then().assertThat().statusCode(200);
    }

    public void validateJsonSchema() {
        File schema = new File(System.getProperty("user.dir") + "/src/main/java/test/automation/data/schema/PostsSchema.json");
        sendGetHttpRequest().then().assertThat().body(matchesJsonSchema(schema));
    }
}
