@pay_bills
Feature: Pay bills activity details
  As a user, once I have successful pay operation on the page bills page, I would like to see suitable messages

  Background:
    Given user is on the login page
    And user enters valid username and password
    And user is on the account summary page
    And user navigates to "Pay Bills" page

  @success_pay_bills
  Scenario: Pay Bills successfully
    When user makes a payment with following info:
      | Payee           | Account  | Amount | Date       | Description |
      | Bank of America | Checking | 285    | 2020-05-20 | CC Payment  |
    Then page title should be "Zero - Pay Bills"
    And after successful pay operation "The payment was successfully submitted." message should be displayed

  @failed_pay_bills_missing_amount
  Scenario: Missing Amount or Date
    When user makes a payment with missing "Amount" info:
      | Payee           | Account  | Date       | Description |
      | Bank of America | Checking | 2020-05-20 | CC Payment  |
    Then user gets an error message as "Please fill out this field." once enters with missing "Amount" info

  @failed_pay_bills_missing_date
  Scenario: Missing Amount or Date
    When user makes a payment with missing "Date" info:
      | Payee           | Account  | Amount | Description |
      | Bank of America | Checking | 133    | CC Payment  |
    Then user gets an error message as "Please fill out this field." once enters with missing "Date" info
