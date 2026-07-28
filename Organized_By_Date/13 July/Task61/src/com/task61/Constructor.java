package com.task61;

enum AccountType {
    CHECKING,
    SAVINGS
}

class Account {

    private int balance;
    private long accountNumber;
    private AccountType accountType;

    // No-argument constructor
    public Account() {
        this.balance = 0;
        this.accountNumber = 12345;
        this.accountType = AccountType.SAVINGS;
    }

    // Parameterized constructor
    public Account(int balance, long accountNumber, AccountType accountType) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    // Getter
    public int getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(int amount) {
        balance += amount;
    }

    // Withdraw method
    public void withdraw(int amount) {
        if (accountType == AccountType.SAVINGS && balance - amount < 0) {
            throw new ArithmeticException("Cannot overdraw a savings account!");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "The account with number " + accountNumber +
                " is of type '" + accountType +
                "' and has a balance of " + balance;
    }
}

public class Constructor {

    public static void main(String[] args) {

        // TEST 1
        System.out.println("=== Test 1 ===");

        // Arrange - create an account using no-argument constructor
        Account account1 = new Account();

        // Act - deposit 10
        account1.deposit(10);

        // Assert
        if (account1.getBalance() == 10) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        // TEST 2
        System.out.println("\n=== Test 2 ===");

        // Arrange - checking account
        Account account2 = new Account(0, 11111, AccountType.CHECKING);

        // Act
        account2.deposit(10);
        account2.withdraw(20);

        // Assert
        if (account2.getBalance() == -10) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        // TEST 3 - Exception
        System.out.println("\n=== Test 3 ===");

        try {
            Account savings = new Account(0, 22222, AccountType.SAVINGS);
            savings.withdraw(10);
        } catch (ArithmeticException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        // TEST 4 - Parameterized Style 
        System.out.println("\n=== Test 4 ===");

        int[] withdrawAmounts = {0, 5, 10};

        for (int amount : withdrawAmounts) {

            Account savings = new Account(0, 33333, AccountType.SAVINGS);

            savings.deposit(10);
            savings.withdraw(amount);

            System.out.println(
                    "Withdraw = " + amount +
                    ", Balance = " + savings.getBalance());
        }

        // ARRAY OF ACCOUNTS 
        System.out.println("\n=== Array of Accounts ===");

        Account[] accounts = {
                new Account(1000, 10001, AccountType.CHECKING),
                new Account(2000, 10002, AccountType.SAVINGS),
                new Account(3000, 10003, AccountType.CHECKING)
        };

        for (Account acc : accounts) {
            System.out.println(acc);
        }

        // LIST OF ACCOUNTS
        System.out.println("\n=== List of Accounts ===");

        java.util.List<Account> accountList = new java.util.ArrayList<>();

        accountList.add(new Account(4000, 20001, AccountType.SAVINGS));
        accountList.add(new Account(5000, 20002, AccountType.CHECKING));
        accountList.add(new Account(6000, 20003, AccountType.SAVINGS));

        for (Account acc : accountList) {
            System.out.println(acc);
        }
    }
}