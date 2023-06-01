package test.automation.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.api.PostMethod;

public class PostSteps {
    @Autowired
    PostMethod post;

    @Given("user prepare data for the payload")
    public void userPrepareDataForThePayload() {
        post.dataPayload();
    }

    @When("user send POST HTTP request")
    public void userSendPOSTHTTPRequest() {
        post.sendPostHttpRequest();
    }

    @Then("user receive valid HTTP response code 201")
    public void userReceiveValidHTTPResponseCode() {
        post.validateHttpResponseCode201();
    }

    @And("user validate the response with payload")
    public void userValidateTheResponseWithPayload() {
        post.validateResponseBody();
    }
}
