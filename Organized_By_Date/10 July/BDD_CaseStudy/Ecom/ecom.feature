Feature: Covered Ecom Application

1. Scenario: Customer Registration

Given the user navigates to the Registration page
When the user enters valid registration details
And the user clicks the Register button
Then the account should be created successfully
And a confirmation message should be displayed

2. Scenario: Customer Login
Given the user navigates to the Login page
When the user enters a valid username and password
And the user clicks on the Login button
Then the user should be logged in successfully
And the Home page should be displayed

3. Scenario: Search for a Product
Given the user navigates to the Home page
When the user enters a valid product name in the search bar
And the user clicks the Search button
Then matching products should be displayed

4. Scenario: View Product Details
Given the user is on the products page
When the user clicks on a product
Then the product details page should be displayed
And the product name, price, description, image, etc. should be displayed

5. Scenario: Add Product to Cart
Given the user is on the product details page
When the user clicks the Add to Cart button
Then the product should be added to the cart
And the cart count should be updated

6. Scenario: Update Product Quantity in Cart
Given the user has a product in the cart
When the user updates the product quantity
And the user saves the changes
Then the cart should display the updated quantity
And the total amount should be updated

7. Scenario: Remove Product from Cart
Given the user has a product in the cart
When the user clicks the Remove button for the product
Then the product should be removed from the cart
And the cart should be updated successfully

8. Scenario: Add Product to Wishlist
Given the user is viewing a product
When the user clicks the Add to Wishlist button
Then the product should be added to the wishlist
And a confirmation message should be displayed

9. Scenario: Successful Checkout
Given the user has products in the cart
When the user proceeds to checkout
And the user enters valid shipping details
Then the checkout process should be completed successfully
And the order summary should be displayed

10. Scenario: Successful Payment
Given the user is on the payment page
When the user enters valid payment details
And the user confirms the payment
Then the payment should be processed successfully
And a payment success message should be displayed

11. Scenario: View Order Confirmation
Given the user has completed a successful payment
When the order is placed
Then an order confirmation page should be displayed
And the order number should be generated

12. Scenario: View Order History
Given the user is logged into the application
When the user navigates to the Order History page
Then the user's previous orders should be displayed
And the order details should be available for viewing

13. Scenario: Successful Logout
Given the user is logged into the application
When the user clicks the Logout button
Then the user should be logged out successfully
And the Login page should be displayed