package com.MethodOverloading;



//Example 1: Banking Application Scenario

public class A_BankingApp {
	
	public void transfer(double amount) {
		System.out.println("Transferred Amount: " + amount);
	}
	
	public void transfer(double amount, String accountNumber) {
		System.out.println("Trasnferred " + amount + " to Account: " + accountNumber);
	}
	
	public void transfer(double amount, String accountNumber, String remarks) {
		System.out.println("Transferred " + amount);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Remarks: " + remarks);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A_BankingApp mt = new A_BankingApp();
		mt.transfer(500);
		mt.transfer(500, "696969");
		mt.transfer(500, "696969", "Bablu" );
	}

}
