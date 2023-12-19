Feature:Top Menu Test
  As a user, I would like to navigate to all pages from top menu bar

  Background: User is on Home page
    Given User navigates to homepage

#  Scenario: Verify user is able to navigate to desktops page successfully
#    When User mouse hovers and clicks on "Desktops" tab and clicks
#    And User selects "Show AllDesktops"
#    Then User can see "Desktops" text in the page

  @author_Annapoorna-Somayaji @sanity @smoke @regression
  Scenario Outline: Verify user is able to navigate to Top Menu Pages successfully
    When User mouse hovers and clicks on "<top menu tab>" tab and clicks
    And User selects "<drop down option>"
    Then User can see "<page heading>" text in the page

    Examples:
      | top menu tab        | drop down option            | page heading        |
      | Desktops            | Show AllDesktops            | Desktops            |
      | Laptops & Notebooks | Show AllLaptops & Notebooks | Laptops & Notebooks |
      | Components          | Show AllComponents          | Components          |
