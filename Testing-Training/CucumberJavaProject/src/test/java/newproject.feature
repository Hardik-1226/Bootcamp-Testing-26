Feature: Login Functionality

  Scenario: Verify successful login with valid credentials

    Given User opens the login page
    When User enters username "student"
    And User enters password "Password123"
    And User clicks on Submit button
    Then User should be redirected to the success page
    And User should see the message "Congratulations"
    And Logout button should be displayed