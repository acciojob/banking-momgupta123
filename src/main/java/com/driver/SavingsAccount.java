package com.driver;

public class SavingsAccount extends BankAccount {
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) throws Exception {
        super(name, balance, 0); // Set minimum balance to 0 for SavingsAccount
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        } else if (amount > getBalance()) {
            throw new Exception("Insufficient Balance");
        } else {
            setBalance(getBalance() - amount);
        }
    }

    public double getSimpleInterest(int years) {
        return getBalance() * rate * years;
    }

    public double getCompoundInterest(int times, int years) {
        double compoundInterest = getBalance();
        for (int i = 0; i < times * years; i++) {
            compoundInterest += (compoundInterest * rate) / times;
        }
        return compoundInterest - getBalance();
    }
}
