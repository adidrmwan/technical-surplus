@Api
Feature: As User, I have be able to post the payload

  @Post
  Scenario: As User, I have be able to post the request using valid payload
    Given user prepare data for the payload
    When user send POST HTTP request
    Then user receive valid HTTP response code 201
    And user validate the response with payload