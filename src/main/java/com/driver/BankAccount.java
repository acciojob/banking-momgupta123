package com.driver;

public class BankAccount {

    private String name;
    private double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        int[] accountNumberDigits = new int[digits];
        int currentSum = 0;

        for (int i = 0; i < digits - 1; i++) {
            int maxDigit = Math.min(9, sum - currentSum - (digits - 1 - i));
            if (maxDigit < 0) {
                throw new Exception("Account Number cannot be generated");
            }
            int randomDigit = (int) (Math.random() * (maxDigit + 1));
            accountNumberDigits[i] = randomDigit;
            currentSum += randomDigit;
        }

        accountNumberDigits[digits - 1] = sum - currentSum;
        if (accountNumberDigits[digits - 1] > 9) {
            throw new Exception("Account Number cannot be generated");
        }

        StringBuilder accountNumber = new StringBuilder();
        for (int digit : accountNumberDigits) {
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }
}
