Feature: Register Functionality
  AS a user I should be able to register by providing mandatory information

  Background:
    Given User is on homepage
    And navigates to register page

  @author_Annapoorna-Somayaji @sanity @smoke @regression
  Scenario: Verify user is able to navigate to register page successfully
    Then User can view "Register" text

  @author_Annapoorna-Somayaji @smoke @regression
  Scenario: verify mandatory fields have error messages
    When User clicks on register button
    Then User can view error messages for mandatory fields
      | First name is required. |
      | Last name is required.  |
      | Email is required.      |
      | Password is required.   |
      | Password is required.   |


  @author_Annapoorna-Somayaji @regression
  Scenario Outline: verify user can create account successfully -first method
    When User clicks on register button
    And User selects gender "<gender>"
    And User enters first name "<firstname>"
    And User enters last name "<lastname>"
    And User selects date "<date>"
    And User selects month "<month>"
    And User selects year "<year>"
    And User enters email
    And User enters password to register "<password>"
    And User enters confirm password "<confirmPassword>"
    And User clicks on register button
    Then USer should see the "Your registration completed" message

    Examples:
      | gender | firstname | lastname | date | month | year | password  | confirmPassword |
      | Female | John      | Smith    | 4    | June  | 2000 | Password1 | Password1       |


  @author_Annapoorna-Somayaji @regression
  Scenario: verify user can create account successfully -second method
    When User clicks on register button
    And enters all the details and registers
      | John      |
      | Smith     |
      | 4         |
      | June      |
      | 2000      |
      | Password1 |
      | Password1 |
    Then USer should see the "Your registration completed" message

