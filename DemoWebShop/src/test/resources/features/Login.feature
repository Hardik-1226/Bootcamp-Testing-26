@Login
Feature: DemoWebShop Login Functionality
  As a registered user of DemoWebShop
  I want to login to my account
  So that I can access my profile and place orders

  Background:
    Given user is on the DemoWebShop login page

  @Smoke @ValidLogin
  Scenario: Login with valid credentials
    When user enters email "test@test.com"
    And user enters password "Password@123"
    And user clicks the login button
    Then user should be logged in successfully

  @Regression @InvalidLogin
  Scenario: Login with invalid credentials
    When user enters email "invalid@test.com"
    And user enters password "WrongPassword"
    And user clicks the login button
    Then login error message should be displayed

  @Regression @EmptyCredentials
  Scenario: Login with empty credentials
    When user clicks the login button
    Then login error message should be displayed

  @DataDriven @LoginScenarios
  Scenario Outline: Login with multiple credentials
    When user enters email "<email>"
    And user enters password "<password>"
    And user clicks the login button
    Then the login result should be "<result>"

    Examples:
      | email              | password      | result  |
      | test@test.com      | Password@123  | success |
      | invalid@test.com   | WrongPass     | failure |
      | test@test.com      | WrongPass     | failure |
