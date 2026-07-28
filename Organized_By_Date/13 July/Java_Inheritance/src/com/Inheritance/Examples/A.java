package com.Inheritance.Examples;

class Account {
	String accountHolder = "Brahm";
	double balance = 10000;
	
	
	
	public void deposit(double amount) {
		System.out.println("Initial Balance: " + balance);
		balance = balance + amount;
		System.out.println("Amount deposited: " + amount);
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Amount withdrawn: " + amount);
	}
	
	public void displayBalance() {
		System.out.println("Remaining Balance is: " + balance);
	}
}

class SavingsAccount extends Account {
	
	public void calculateInterest() {
		double interest = balance * 5 / 100;
		System.out.println("Interest earned: " + interest);
	}
}

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SavingsAccount sa = new SavingsAccount();
		System.out.println("Account Holder: " + sa.accountHolder);
		sa.deposit(5000);
		sa.withdraw(1000);
		sa.displayBalance();
		sa.calculateInterest();
	}

}
