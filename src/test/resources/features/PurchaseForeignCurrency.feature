@purchase_foreign_currency
Feature: Purchase Foreign Currency

  Background:
    Given user is on the login page
    And user enters valid username and password
    And user is on the account summary page
    And user navigates to "Pay Bills" page

  @available_currencies
  Scenario: Available currencies
    Given the user accesses the "Purchase Foreign Currency" tab
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  @not_selected_currency
  Scenario: Error message for not selecting currency
    Given the user accesses the "Purchase Foreign Currency" tab
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  @not_entering_value
  Scenario: Error message for not entering value
    Given the user accesses the "Purchase Foreign Currency" tab
    When user tries to calculate cost without entering a value
    Then error message should be displayed