@account_summary
Feature: Account Summary Details
  As a user, once I am on the account summary page, I would like to see mentioned account types in the account summary page.

  Scenario: Account summary page layout details
    Given user is on the login page
    And user enters valid username and password
    When user is on the account summary page
    Then page title should be "Zero - Account Summary"
    And account summary page should include the following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And credit accounts table must have the following columns
      | Account     |
      | Credit Card |
      | Balance     |