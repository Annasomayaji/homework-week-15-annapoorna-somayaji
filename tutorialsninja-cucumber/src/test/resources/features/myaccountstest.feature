Feature: My Accounts
  As a user, I would like to use all the options from My Account

  Background:   Background: User is on Home page
    Given User navigates to homepage

  @author_Annapoorna-Somayaji
  Scenario: Verify the user is able to navigate to register page successfully
    When User clicks on My Account link
    And User selects "Register" from the drop down
    Then User should be able to view "Register Account" heading in the navigated page

  @author_Annapoorna-Somayaji
  Scenario: Verify the user is able to navigate to Login page successfully
    When User clicks on My Account link
    And User selects "Login" from the drop down
    Then User should be able to view "Returning Customer" sub heading in the navigated page

  @author_Annapoorna-Somayaji
  Scenario: Verify the user is able to navigate to register page and register successfully
    When User clicks on My Account link
    And User selects "Register" from the drop down
    And User enters the following details in the register account page and submits
      | Annu        |
      | Som         |
      | 07712342013 |
      | Password1   |
      | Password1   |
      | Yes         |
    Then User can view "Your Account Has Been Created!" message in Account Success page


  @author_Annapoorna-Somayaji
  Scenario: Verify the user is able to register and logout successfully.
    When User clicks on My Account link
    And User selects "Register" from the drop down
    And User enters the following details in the register account page and submits
      | Annu        |
      | Som         |
      | 07712342013 |
      | Password1   |
      | Password1   |
      | Yes         |
    And User clicks on Continue button on account Register Success page
    And User clicks on My Account link
    And User selects "Logout" from the drop down
    Then User can view "Account Logout" text in the heading

  @author_Annapoorna-Somayaji
  Scenario: Verify the user is able to login with valid credentials successfully.
    When User clicks on My Account link
    And User selects "Login" from the drop down
    And User logs in with the following credentials
      | john.smith@gmail.com |
      | Password1            |
    Then User is able to view "My Account" text


  @author_Annapoorna-Somayaji @onlythistest
  Scenario: Verify the user is able to login and logout successfully.
    When User clicks on My Account link
    And User selects "Login" from the drop down
    And User logs in with the following credentials
      | john.smith@gmail.com |
      | Password1            |
    And User selects "Logout" from the drop down
    Then User is able to view "Account Logout" heading