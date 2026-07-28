@Checkout
Feature: DemoWebShop Checkout Functionality
  As a logged-in user of DemoWebShop
  I want to complete the checkout process
  So that I can place an order for items in my cart

  Background:
    Given user is logged in to DemoWebShop
    And user has items in the shopping cart

  @Smoke @CompleteCheckout
  Scenario: Complete checkout with Cash On Delivery
    When user proceeds to checkout from cart
    And user completes the billing address step
    And user completes the shipping address step
    And user selects ground shipping method
    And user selects cash on delivery payment
    And user completes payment information
    And user confirms the order
    Then order confirmation message should be displayed

  @Regression @CheckoutVerification
  Scenario: Verify checkout page loads
    When user proceeds to checkout from cart
    Then the checkout page should be displayed

  @DataDriven @ShippingMethods
  Scenario Outline: Checkout with different shipping methods
    When user proceeds to checkout from cart
    And user completes the billing address step
    And user completes the shipping address step
    And user selects "<shippingMethod>" shipping method
    And user selects cash on delivery payment
    And user completes payment information
    And user confirms the order
    Then order confirmation message should be displayed

    Examples:
      | shippingMethod |
      | Ground         |
      | Next Day Air   |
