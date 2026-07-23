Feature : Login Functionality

  Scenario: Successful Login with Valid Credentials
    Given User opens the Chrome browser
    When User navigates to the application URL
    Then User should be on the login page
    When User enters the username and password
    And User clicks the Login button
    Then User should be logged in successfully