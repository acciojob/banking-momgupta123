package com.driver;

public class StudentAccount extends BankAccount {

    String institutionName;

    public StudentAccount(String name, double balance, String institutionName) {
        super(name, balance, 0); // Set minimum balance to 0 for StudentAccount
        this.institutionName = institutionName;
    }

    // You can add more methods specific to StudentAccount here if needed
    // For example:
    public void displayStudentInfo() {
        System.out.println("Student Name: " + getName());
        System.out.println("Institution Name: " + institutionName);
        System.out.println("Account Balance: " + getBalance());
    }
}
