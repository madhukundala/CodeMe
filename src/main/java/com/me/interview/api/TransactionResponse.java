package com.me.interview.api;

public class TransactionResponse {

    private String balance;
    private String transactions;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "TransactionResponse  {" +
                "balance='" + balance + '\'' +
                ", transactions='" + transactions + '\'' +
                '}';
    }
}
