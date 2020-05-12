@account_activity
Feature: Account activity details
  As a user, once I navigate to account activity page, I would like to see mentioned account drop down options

  Background:
    Given user is on the login page
    And user enters valid username and password
    And user is on the account summary page
    And user navigates to "Account Activity" page

  Scenario: Account activity page drop down details
    Then page title should be "Zero - Account Activity"
    And account drop down option should be "Savings"
    And account drop down should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And transactions table should have the following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |