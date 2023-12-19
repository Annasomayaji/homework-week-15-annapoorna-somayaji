Feature: Login test
  As a user, I would like to be able to logout successfully using valid credentials

  Background: User is on the homepage
    Given User is on homepage

  @author_Annapoorna-Somayaji
  Scenario: Verify user is able to login successfully
    When User logins with valid email and password
      | Admin    |
      | admin123 |

    Then User is able to view "Dashboard" message

  @author_Annapoorna-Somayaji
  Scenario: Verify the logo is displayed on home page
    When User logins with valid email and password
      | Admin    |
      | admin123 |
    Then User can view the logo on the homepage

  @author_Annapoorna-Somayaji @onlythistest
  Scenario Outline: Verify the error message for invalid login credentials

    When User enters "<username>" in username field
    And User enters "<password>" in password field
    And User clicks on Login button
    Then User can view "<errorMessage>" error message for "<username>" and "<password>"

    Examples:
      | username          | password | errorMessage        |
      |                   |          | Required            |
      | test123@gmail.com |          | Required            |
      |                   | test123  | Required            |
      | test123@gmail.com | test123  | Invalid credentials |


  @author_Annapoorna-Somayaji
  Scenario: Verify the user can logout successfully after logging in
    When User logins with valid email and password
      | Admin    |
      | admin123 |
    And User logs out by clicking "Logout"
    Then User can view "Login" panel



