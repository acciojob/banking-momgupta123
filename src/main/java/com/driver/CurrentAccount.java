package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000); // Minimum balance is 5000 for a current account
        this.tradeLicenseId = tradeLicenseId;

        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        char[] chars = tradeLicenseId.toCharArray();
        Arrays.sort(chars);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                throw new Exception("Valid License cannot be generated");
            }
        }
    }
}
