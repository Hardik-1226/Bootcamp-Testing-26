Feature: Checking Login & Logout Functionality

  Scenario: Successful Login with Valid Credentials
    Given User Should Open Chrome Browser
    When User Should Enter Url in Browser
    When User Should Navigate HomePage
    And Enter UserName and Password in Edit Box
    And Click On Login PushButton
    Then Message displayed Login Successfully