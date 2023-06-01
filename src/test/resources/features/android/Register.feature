@Android @RegisterUser
Feature: As user, I have be able to register, So that I can login using my account

  Background:
    Given user on register screen

  @SuccessRegister @Positive
  Scenario Outline: User be able to success register new account
    When user input "<type_name>" name
    And user input "<type_email>" email
    And user input "<type_password>" password
    And user input "<type_confirm_password>" confirmation password
    And user tap register button
    Then user see success "<message>" is displayed

    Examples:
      | type_name   | type_email  |type_password    | type_confirm_password | message                   |
      | valid       | valid       | valid           | valid                 | Registration Successful   |

  @FailedRegister @Negative
  Scenario Outline: User failed to register new account
    When user input "<type_name>" name
    And user input "<type_email>" email
    And user input "<type_password>" password
    And user input "<type_confirm_password>" confirmation password
    And user tap register button
    Then user see error "<message>" is displayed

    Examples:
    | type_name   | type_email  | type_password   | type_confirm_password | message                    |
    | none        | valid       | valid           | valid                 | Enter Full Name            |
    | valid       | none        | valid           | valid                 | Enter Valid Email          |
    | valid       | valid       | none            | valid                 | Enter Password             |
    | valid       | valid       | valid           | none                  | Password Does Not Matches  |
    | valid       | invalid     | valid           | valid                 | Enter Valid Email          |
    | valid       | valid       | valid           | invalid               | Password Does Not Matches  |