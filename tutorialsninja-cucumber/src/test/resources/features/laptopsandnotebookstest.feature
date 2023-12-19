Feature:Laptop and Notebooks Test
  As a user, I would like to navigate to laptops and notebooks page and add product to cart successfully

  Background: User is on Home page
    Given User navigates to homepage

  @author_Annapoorna-Somayaji
  Scenario: Verify that products price display from high to low
    When User mouse hovers and clicks "Laptops & Notebooks" tab and clicks
    And User select "Show AllLaptops & Notebooks"
    And User selects sort by position "Price (High > Low)" from laptops and notebooks page
    Then User can view products in the descending order of price

  @author_Annapoorna-Somayaji
  Scenario:Verify the user can select a product successfully
    When User mouse hovers and clicks "Laptops & Notebooks" tab and clicks
    And User select "Show AllLaptops & Notebooks"
    And User selects sort by position "Price (High > Low)" from laptops and notebooks page
    And User selects the product "MacBook"
    Then User can view "MacBook" text in the product page heading

  @author_Annapoorna-Somayaji
  Scenario: Verify the user can view success message when a product is added to cart
    When User mouse hovers and clicks "Laptops & Notebooks" tab and clicks
    And User select "Show AllLaptops & Notebooks"
    And User selects sort by position "Price (High > Low)" from laptops and notebooks page
    And User selects the product "MacBook"
    And User clicks on Add To Cart button
    Then User can view "Success: You have added MacBook to your shopping cart!"

  @author_Annapoorna-Somayaji
  Scenario: Verify the product is in the shopping cart when it is added
    When User mouse hovers and clicks "Laptops & Notebooks" tab and clicks
    And User select "Show AllLaptops & Notebooks"
    And User selects sort by position "Price (High > Low)" from laptops and notebooks page
    And User selects the product "MacBook"
    And User clicks on Add To Cart button
    And User clicks on "shopping cart" link into success message
    Then User can view "Shopping Cart" in page heading and "MacBook" in product name

  @author_Annapoorna-Somayaji
  Scenario: Verify the shopping cart can be updated after the product has been added
    When User mouse hovers and clicks "Laptops & Notebooks" tab and clicks
    And User select "Show AllLaptops & Notebooks"
    And User selects sort by position "Price (High > Low)" from laptops and notebooks page
    And User selects the product "MacBook"
    And User clicks on Add To Cart button
    And User clicks on "shopping cart" link into success message
    And User updates quantity to "2"
    And User clicks on update tab
    Then User can view "Success: You have modified your shopping cart!", "$1,204.00" in the cart.

  @author_Annapoorna-Somayaji
  Scenario: Verify the user can navigate to check out page after adding a product to cart
    When User mouse hovers and clicks "Laptops & Notebooks" tab and clicks
    And User select "Show AllLaptops & Notebooks"
    And User selects sort by position "Price (High > Low)" from laptops and notebooks page
    And User selects the product "MacBook"
    And User clicks on Add To Cart button
    And User clicks on "shopping cart" link into success message
    And User updates quantity to "2"
    And User clicks on update tab
    And User clicks on Checkout button
    Then User can view "Checkout" text in the page heading
    And User can view "New Customer" check out option

  @author_Annapoorna-Somayaji
  Scenario: Verify the user can navigate to check out page after adding a product to cart
    When User mouse hovers and clicks "Laptops & Notebooks" tab and clicks
    And User select "Show AllLaptops & Notebooks"
    And User selects sort by position "Price (High > Low)" from laptops and notebooks page
    And User selects the product "MacBook"
    And User clicks on Add To Cart button
    And User clicks on "shopping cart" link into success message
    And User updates quantity to "2"
    And User clicks on update tab
    And User clicks on Checkout button
    And User checks out using "Guest Checkout" radio button
    And enter following details for checkout
      | Annu                            |
      | Som                             |
      | annu.som@gmail.com              |
      | 07712345012                     |
      | 5 high view                     |
      | London                          |
      | TW3 4RK                         |
      | United Kingdom                  |
      | Bristol                         |
      | Please send as special delivery |
    Then User can view "Warning: Payment method required!" for payment required







