@Android @LoginUser
Feature: As user, I have be able to login, So that I can see my homepage

  Background:
    Given user on login screen

  @Positive @SuccessLogin
  Scenario Outline: User success login with existing user
    When user input "<type_email>" email
    And  user input "<type_password>" password
    And  user tap login button
    Then user on home screen

    Examples:
      |type_email       |type_password    |
      |existing         | existing        |

  @Negative @FailedLogin
  Scenario Outline: User failed to login with invalid input
    When user input "<type_email>" email
    And  user input "<type_password>" password
    And  user tap login button
    Then user see error "<message>" is displayed

    Examples:
    |type_email     |type_password  |message              |
    |none           | valid         |Enter Valid Email    |
    |valid          | none          |Enter Valid Email    |
    |invalid        | none          |Enter Valid Email    |

  @Negative @FailedLogin @WrongDataUser
  Scenario Outline: User failed to login with wrong data existing user
    When user input "<type_email>" email
    And  user input "<type_password>" password
    And  user tap login button
    Then user see toast "<message>" is displayed

    Examples:
      |type_email       |type_password    |message                    |
      |valid            | invalid         |Wrong Email or Password    |