package com.me.interview.pojo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"transactionId", "fromAccountId", "toAccountId", "createdAt"
        , "amount", "transactionType", "relatedTransaction"})
public class TransactionRequest {

    private String transactionId;
    private String fromAccountId;
    private String toAccountId;
    private String createdAt;
    private String amount;
    private String transactionType;
    private String relatedTransaction;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(String fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public String getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(String toAccountId) {
        this.toAccountId = toAccountId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getRelatedTransaction() {
        return relatedTransaction;
    }

    public void setRelatedTransaction(String relatedTransaction) {
        this.relatedTransaction = relatedTransaction;
    }


    @Override
    public String toString() {
        return "TransactionRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", fromAccountId='" + fromAccountId + '\'' +
                ", toAccountId='" + toAccountId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", amount='" + amount + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", relatedTransaction='" + relatedTransaction + '\'' +
                '}';
    }
}
