Feature:Desktop Test
  As a user, I would like to select products from desktop

  Background: User is on Home page
    Given User navigates to homepage

  @author_Annapoorna-Somayaji
  Scenario Outline: Verify that the products arrange in alphabetical order
    When User mouse hovers and clicks "<top menu tab>" tab and clicks
    And User select "<drop down option>"
    And User selects sort by position "Name (Z - A)"
    Then User can view products displayed in alphabetical order.


    Examples:
      | top menu tab        | drop down option            |
      | Desktops            | Show AllDesktops            |
      | Laptops & Notebooks | Show AllLaptops & Notebooks |

  @author_Annapoorna-Somayaji
  Scenario Outline: Verify the user can click on the required product
    When User mouse hovers and clicks "Desktops" tab and clicks
    And User select "Show AllDesktops"
    And User selects "£Pound Sterling" from currency drop down
    And User selects sort by position "Name (A - Z)"
    And User selects "<product>" from product list
    Then User can view "<product>" text

    Examples:
      | product      |
      | HTC Touch HD |
      | iPhone       |
      | iPod Classic |
      | MacBook      |
      | MacBook Air  |
      | Sony VAIO    |

  @author_Annapoorna-Somayaji
  Scenario Outline: Verify the products are added to shopping cart successfully
    When User mouse hovers and clicks "Desktops" tab and clicks
    And User select "Show AllDesktops"
    And User selects "£Pound Sterling" from currency drop down
    And User selects sort by position "Name (A - Z)"
    And User selects "<product>" from product list
    And User selects "1" from Quantity
    And User clicks on Add to cart button
    Then User can view "Success: You have added <product> to your shopping cart!" message
    And User clicks on "shopping cart" link into success message
    Then User can view "Shopping Cart" ,"<product>","<model>","<price>"

    Examples:
      | product      | model      | price   |
      | HTC Touch HD | Product 1  | £74.73  |
      | iPhone       | product 11 | £75.46  |
      | iPod Classic | product 20 | £74.73  |
      | MacBook      | Product 16 | £368.73 |
      | MacBook Air  | Product 17 | £736.23 |
      | Sony VAIO    | Product 19 | £736.23 |







