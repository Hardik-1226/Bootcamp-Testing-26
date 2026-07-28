package com.ExceptionHandling;

public class F {

    double balance = 5000;

    void withdraw(double amount) {

        try {
            if (amount > balance) {
                System.out.println("Insufficient balance");
            } else {
                balance = balance - amount;
                System.out.println("Withdrawn amount: " + amount);
                System.out.println("Remaining balance: " + balance);
            }
        } catch (Exception e) {
            System.out.println("Got an error " + e.getMessage());
        } finally {
            System.out.println("Transaction complete");
        }
    }

    public static void main(String[] args) {

        F obj = new F();

        obj.withdraw(6000);
        obj.withdraw(2000);
    }
}