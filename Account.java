package com.bankapp.model;

public class Account {
    private String accountNumber;
    private String accountType;
    private String customerName;
    private double balance;
    private String safetyDepositBox;

    public Account(String accountNumber, String accountType, String customerName, double balance, String safetyDepositBox) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.customerName = customerName;
        this.balance = balance;
        this.safetyDepositBox = safetyDepositBox;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public String getSafetyDepositBox() {
        return safetyDepositBox;
    }
}
