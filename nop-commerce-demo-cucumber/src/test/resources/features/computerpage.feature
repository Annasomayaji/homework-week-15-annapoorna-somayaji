Feature: Computer page functionality
  As a user, I should be able to navigate to computer page and build my own computer

  Background:
    Given User is on homepage
    When User clicks on "Computer" navigation tab


  @author_Annapoorna-Somayaji @sanity @smoke @regression
  Scenario: Verify the user should navigate to computer page successfully
    Then User should see "Computers" in page title

  @author_Annapoorna-Somayaji @smoke @regression
  Scenario Outline: Verify the user should navigate to desktop page successfully
    When User clicks on "<option from computer dropdown>" tab
    Then User should see "<title text>" in page title upon navigating

    Examples:
      | option from computer dropdown | title text |
      | Desktops                      | Desktops   |
#Add Notebooks and Software drop down options here when required

  @author_Annapoorna-Somayaji @onlythistest @regression
  Scenario Outline: Verify the user is able to build his own computer and add to cart successfully
    When User clicks on "Desktops" tab
    And User clicks on "Build your own computer" product name
    And User selects product requirements "<processor>","<ram>","<hdd>","<os>","<software>" for Build your own computer
    And User clicks on Add to Cart button
    Then User can view success message "The product has been added to your shopping cart"

    Examples:
      | processor                                       | ram           | hdd               | os                      | software                   |
      | 2.2 GHz Intel Pentium Dual-Core E2200           | 2 GB          | 320 GB            | Vista Home [+$50.00]    | Microsoft Office [+$50.00] |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 4GB [+$20.00] | 400 GB [+$100.00] | Vista Premium [+$60.00] | Acrobat Reader [+$10.00]   |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 8GB [+$60.00] | 320 GB            | VistaHome [+$50.00]     | Total Commander [+$5.00]   |
