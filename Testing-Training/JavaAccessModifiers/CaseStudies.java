package com.BDDTestCase.DecisionMakingStatement;


public class CaseStudies {

 public static void main(String[] args) {

//	//Case 1: Check Voting Eligibility
//     int age = 20;
//
//     if (age >= 18) {
//         System.out.println("Eligible for Voting");
//     } else {
//         System.out.println("Not Eligible for Voting");
//     }
//
//     System.out.println("--------------------------------");
//
//     // Case 2: Check Bank Account Balance
//
//     int accountBalance = 10000;
//     int withdrawAmount = 7000;
//
//     // Check balance before withdrawal
//     if (accountBalance >= withdrawAmount) {
//         accountBalance -= withdrawAmount;
//         System.out.println("Withdrawal Successful");
//         System.out.println("Remaining Balance: " + accountBalance);
//     } else {
//         System.out.println("Insufficient Balance");
//     }
//
//     System.out.println("--------------------------------");
//
//     // Case 3: Login Validation (Automation Testing)
//
//     String actualUsername = "student";
//     String actualPassword = "Password123";
//
//     String enteredUsername = "student";
//     String enteredPassword = "Password123";
//
//     // Validate username and password
//     if (actualUsername.equals(enteredUsername)
//             && actualPassword.equals(enteredPassword)) {
//
//         System.out.println("Login Successful");
//     } else {
//         System.out.println("Invalid Credentials");
//     }
//
//     System.out.println("--------------------------------");
//
//     // Case 4: E-commerce Discount
//
//     double purchaseAmount = 6500;
//
//     // Apply 10% discount if purchase is above ₹5000
//     if (purchaseAmount > 5000) {
//
//         double discount = purchaseAmount * 0.10;
//         double finalAmount = purchaseAmount - discount;
//
//         System.out.println("Discount: " + discount);
//         System.out.println("Final Amount: " + finalAmount);
//
//     } else {
//         System.out.println("No Discount Applicable");
//     }
//
//     System.out.println("--------------------------------");
//
//     // Case 5: Marks Validation
//
//     int marks = 72;
//
//     // Check pass or fail
//     if (marks >= 35) {
//         System.out.println("Student Passed");
//     } else {
//         System.out.println("Student Failed");
//     }
//
//     System.out.println("--------------------------------");
//
//     // Case 6: Selenium Automation Example
//
//     // Expected page title
//     String expectedTitle = "Test Login";
//
//     // Actual page title
//     String actualTitle = "Test Login | Practice Test Automation";
//
//     // Verify title
//     if (actualTitle.contains(expectedTitle)) {
//         System.out.println("Selenium Test Passed");
//     } else {
//         System.out.println("Selenium Test Failed");
//     }
//
//     System.out.println("--------------------------------");
//
//     // Case 7: API Testing Example (Rest Assured)
//
//     int statusCode = 200;
//
//     // Verify API response
//     if (statusCode == 200) {
//         System.out.println("API Test Passed");
//     } else {
//         System.out.println("API Test Failed");
//     }

     
//     using switch case statements print months from 2026
     String[] Months_name= {"January","February","March","April","May","June",
    		 "July","August","September","October","November","December"};
     
     a:for(int i=0;i<12;i++)
     {
    	 switch(i) {
    	 case 0:
             System.out.println(Months_name[i]);
             break;
         case 1:
             System.out.println(Months_name[i]);
             break;
         case 2:
             System.out.println(Months_name[i]);
             break;
         case 3:
             System.out.println(Months_name[i]);
             break;
         case 4:
             System.out.println(Months_name[i]);
             break;
         case 5:
             System.out.println(Months_name[i]);
             break;
         case 6:
             System.out.println(Months_name[i]);
             break;
         case 7:
             System.out.println(Months_name[i]);
             break;
         case 8:
             System.out.println(Months_name[i]);
             break;
         case 9:
             System.out.println(Months_name[i]);
             break;
         case 10:
             System.out.println(Months_name[i]);
             break;
         case 11:
             System.out.println(Months_name[i]);
             break;
         default:
             System.out.println("Invalid Month");
    	 }
     }
 }
}
