Feature: Checking Login & Logout Functionality

Scenario: Successful Login with valid Credentials
Given User Should Open Chrome Browser
When User Should enter Url in Browser
When User Should Navigate Homepage
When User Enter Username and Password in Edit Box
And Click On Login PushButton
Then Message displayed Login Successfully 