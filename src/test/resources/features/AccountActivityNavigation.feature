@account_activity_navigation
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given user is on the login page
    And user enters valid username and password
    And user is on the account summary page

  @savings
  Scenario: Savings account redirect
    When the user clicks on "Savings" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Savings" selected

  @brokerage
  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Brokerage" selected

  @checking
  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Checking" selected

  @credit_card
  Scenario: Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Credit Card" selected

  @loan
  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "Loan" selected