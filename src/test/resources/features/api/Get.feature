@Api
Feature: As User, I want to verify the response with json schema

  @Get
  Scenario: As User, I have be able to get the response
    Given user set GET api endpoints
    When user send GET HTTP request
    Then user receive valid HTTP response code 200
    And user validate the response with json schema