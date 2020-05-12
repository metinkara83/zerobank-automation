@login
Feature: Login Functionality
  As a user, I would like to login to the application with a valid username and password.

  Background:
    Given user is on the login page

  @loginValid
  Scenario: Login with Valid Credentials
    When user enters valid username and password
    Then user is on the account summary page

  @loginInvalid
  Scenario Outline: Login with Invalid Credentials
    When user enters invalid "<username>" and "<password>"
    Then user sees error message

    Examples:
      | username | password |
      | abcd     | 1234     |
      |          | 567      |
      | defgt    |          |
      |          |          |

#  @loginInvalid
#  Scenario: Login with Invalid Credentials
#    When user enters invalid information
#      | username | password |
#      | abcd     | 1234     |
#    Then user sees error message