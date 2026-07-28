Feature: Banking Application

# Customer Registration
Scenario: Register a new customer successfully
Given the customer is on the Registration page
When the customer enters all mandatory details with valid information
And clicks on the Register button
Then the customer account should be created successfully
And a confirmation message should be displayed

# Customer Login
Scenario: Login with valid credentials
Given the customer is on the Login page
When the customer enters a valid username and password
And clicks on the Login button
Then the customer should be logged in successfully
And the Account Summary page should be displayed

# Account Summary
Scenario: View Account Summary
Given the customer is logged into the banking application
When the customer navigates to the Account Summary page
Then the customer should see the account number, account type, available balance, and account status

# Balance Enquiry
Scenario: Check Account Balance
Given the customer is logged into the banking application
When the customer clicks on Balance Enquiry
Then the available account balance should be displayed

# Fund Transfer
Scenario: Transfer funds successfully
Given the customer is logged into the banking application
And the beneficiary is already added
When the customer enters the transfer amount
And selects the beneficiary
And clicks on the Transfer button
Then the amount should be transferred successfully
And a transaction reference number should be generated

# Add Beneficiary
Scenario: Add a new beneficiary
Given the customer is logged into the banking application
When the customer enters the beneficiary details
And clicks on the Add Beneficiary button
Then the beneficiary should be added successfully
And a confirmation message should be displayed

# Mini Statement
Scenario: View Mini Statement
Given the customer is logged into the banking application
When the customer clicks on Mini Statement
Then the last ten transactions should be displayed

# Transaction History
Scenario: View Transaction History
Given the customer is logged into the banking application
When the customer selects the From Date and To Date
And clicks on the Search button
Then all transactions within the selected date range should be displayed

# Change Password
Scenario: Change Password successfully
Given the customer is logged into the banking application
When the customer enters the current password
And enters a new password
And confirms the new password
And clicks on the Update Password button
Then the password should be updated successfully
And a success message should be displayed

# Logout
Scenario: Logout successfully
Given the customer is logged into the banking application
When the customer clicks on the Logout button
Then the customer should be logged out successfully
And the Login page should be displayed