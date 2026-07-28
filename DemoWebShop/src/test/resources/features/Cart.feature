@Cart
Feature: DemoWebShop Shopping Cart Functionality
  As a logged-in user of DemoWebShop
  I want to manage my shopping cart
  So that I can review and modify items before checkout

  Background:
    Given user is logged in to DemoWebShop

  @Smoke @ViewCart
  Scenario: View shopping cart
    When user navigates to the shopping cart
    Then the shopping cart page should be displayed

  @Regression @RemoveFromCart
  Scenario: Remove product from cart
    Given user has items in the shopping cart
    When user removes the first product from cart
    Then the cart item count should decrease

  @Regression @UpdateQuantity
  Scenario: Update product quantity in cart
    Given user has items in the shopping cart
    When user updates the quantity to 3
    Then the cart should reflect the updated quantity

  @Regression @ContinueShopping
  Scenario: Continue shopping from cart
    When user navigates to the shopping cart
    And user clicks continue shopping
    Then user should be on the home page

  @DataDriven @CartOperations
  Scenario Outline: Perform cart operations
    When user navigates to the shopping cart
    And user updates the quantity to <quantity>
    Then the cart should reflect the updated quantity

    Examples:
      | quantity |
      | 1        |
      | 2        |
      | 5        |
