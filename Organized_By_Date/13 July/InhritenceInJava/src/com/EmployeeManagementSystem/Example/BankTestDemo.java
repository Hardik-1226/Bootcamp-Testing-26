package com.EmployeeManagementSystem.Example;

class Account {
    String account_holder_name = "Raghavendra";
    double balance = 10000;
    // Deposit amount
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited: " + amount);
    }
    // Withdraw amount
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Amount Withdrawn: " + amount);
    }
    // Display current balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}
class SavingAccount extends Account {
    // Calculate 5% interest
    public void calculateInterest() {
        double interest = balance * 5 / 100;
        System.out.println("Interest Earned: " + interest);
    }
}

public class BankTestDemo {
    public static void main(String[] args) {
        SavingAccount sa = new SavingAccount();
        System.out.println("Account Holder Name: " + sa.account_holder_name);
        sa.deposit(5000);
        sa.withdraw(2000);
        sa.displayBalance();
        sa.calculateInterest();
    }
}