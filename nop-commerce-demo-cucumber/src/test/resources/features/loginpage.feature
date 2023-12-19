Feature: Login feature
  As a user I am able to login using valid credentials

  @author_Annapoorna-Somayaji @sanity @smoke @regression
  Scenario: User should navigate to login page successfully
    Given  User is on homepage
    When User clicks on login link
    Then User should navigate to login page successfully

  @author_Annapoorna-Somayaji @smoke @regression
  Scenario: Verify error message for invalid credentials
    Given User is on homepage
    When User clicks on login link
    And User enters email "abc@gmail.com"
    And User enters password "Password1"
    And user clicks on Login Button
    Then User should see an error message "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect"

  @author_Annapoorna-Somayaji @smoke @regression
  Scenario: Verify that user should login successfully with valid credentials
    Given User is on homepage
    When User clicks on login link
    And User enters email "sally.smith@gmail.com"
    And User enters password "Password1"
    And user clicks on Login Button
    Then User is able to view the "Log out" link

  @author_Annapoorna-Somayaji @regression
  Scenario: Verify that the user should logout successfully
    Given User is on homepage
    When User clicks on login link
    And User enters email "sally.smith@gmail.com"
    And User enters password "Password1"
    And user clicks on Login Button
    And user clicks on Logout link
    Then User is able to view the Login link
