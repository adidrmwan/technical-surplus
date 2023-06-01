package test.automation.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.api.GetMethod;

public class GetSteps {
    @Autowired
    GetMethod get;

    @Given("user set GET api endpoints")
    public void userSetGETApiEndpoints() {
        get.setApiEndpoint();
    }

    @When("user send GET HTTP request")
    public void userSendGETHTTPRequest() {
        get.sendGetHttpRequest();
    }

    @Then("user receive valid HTTP response code 200")
    public void userReceiveValidHTTPResponseCode() {
        get.validateHttpResponseCode200();
    }

    @And("user validate the response with json schema")
    public void userValidateTheResponseWithJsonSchema() {
        get.validateJsonSchema();
    }
}
