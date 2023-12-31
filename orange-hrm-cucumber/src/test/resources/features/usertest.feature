Feature: User Test
  As an admin user, I like to add, verify and delete user.

  Background: User is on the homepage
    Given User is on homepage

  @author_Annapoorna-Somayaji
  Scenario: Verify that user can navigate to admin page
    When  When User logins with valid email and password
      | Admin    |
      | admin123 |
    And User clicks on Admin tab
    Then User can view "System Users" text on the home page

  @author_Annapoorna-Somayaji
  Scenario: Verify that the admin can add user
    When  When User logins with valid email and password
      | Admin    |
      | admin123 |
    And User clicks on Admin tab
    And USer clicks on Add button
    Then User can view "Add User" heading text on Add User page

  @author_Annapoorna-Somayaji
  Scenario Outline: Verify that the admin can add user successfully
    When User has logged in as Admin using the following credentials and Add User page
      | Admin    |
      | admin123 |
    And User adds a user with "<role>","<employeeName>" ,"<userName>", "<status>","<password>", "<confirmPassword>"
    Then User can view success message "<successMessage>"

    Examples:
      | role  | employeeName   | userName       | status  | password  | confirmPassword | successMessage     |
      | Admin | Peter Anderson | Peter.Anderson | Enabled | Password1 | Password1       | Successfully Saved |


  @author_Annapoorna-Somayaji
  Scenario Outline: Verify that the user created can be searched
    When  When User logins with valid email and password
      | Admin    |
      | admin123 |
    And User clicks on Admin tab
    And User searches with "<userName>","<role>", "<status>"
    Then User can view the searched user in the "<result>" list

    Examples:
      | userName       | role  | status  | result       |
      | Peter.Anderson | Admin | Enabled | Record Found |


  @author_Annapoorna-Somayaji
  Scenario Outline: Verify the admin can delete the user successfully
    When  When User logins with valid email and password
      | Admin    |
      | admin123 |
    And User clicks on Admin tab
    And User searches with "<userName>","<role>", "<status>"
    And User deletes the user in the search result
    Then User can view "Successfully Deleted" message

    Examples:
      | userName       | role  | status  |
      | Peter.Anderson | Admin | Enabled |

  @author_Annapoorna-Somayaji
  Scenario Outline: Verify that the user created can be searched and message can be verified
    When  When User logins with valid email and password
      | Admin    |
      | admin123 |
    And User clicks on Admin tab

    #Using overridden method for searching
    And User searches with "<userName>","<role>", "<employeeName>","<status>"
    Then User can view the searched user in the "<result>" list and view the "<userName>"

    Examples:
      | userName       | role  | employeeName   | status  | result       |
      | Peter.Anderson | Admin | Peter Anderson | Enabled | Record Found |
      | Admin          | Admin | Paul Collings  | Enabled | Record Found |
      | Cassidy.Hope   | ESS   | Cassidy Hope   | Enabled | Record Found |
      | Nina.Patel     | ESS   | Nina Patel     | Enabled | Record Found |
      | Odis.Adalwin   | Admin | Odis Adalwin   | Enabled | Record Found |