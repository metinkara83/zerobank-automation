Feature: Statements and Documents details

  Background:
    Given user is on the login page
    And user enters valid username and password
    And user is on the account summary page
    And user navigates to "Online Statements" page

  @recent_statements
  Scenario Outline: Recent statements per year
    When the user selects the Recent Statements Year <year>
    Then <count> statements should be displayed for that <year>

    Examples:
      | year | count |
      | 2009 | 2     |
      | 2010 | 2     |
      | 2011 | 2     |
      | 2012 | 1     |

  @download_statements
  Scenario Outline: Download statements
    When the user selects the Recent Statements Year <year>
    And the user clicks on statement "<statement>"
    Then the downloaded "<statement>" file name should contain "<name>"
    And the file type of "<statement>" should be "pdf"

    Examples:
      | year | statement               | name     |
      | 2009 | Statement 31/11/09(57K) | 31-11-09 |
      | 2010 | Statement 01/12/10(57K) | 01-12-10 |
      | 2011 | Statement 05/12/11(57K) | 05-12-11 |
      | 2012 | Statement 01/10/12(57K) | 01-10-12 |