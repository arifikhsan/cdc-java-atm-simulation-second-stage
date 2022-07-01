package org.example.model;

import java.time.LocalDateTime;

public class TransferModel extends Transaction {
    private AccountModel fromAccountModel;
    private AccountModel toAccountModel;
    private Integer amount;
    private LocalDateTime dateTime;
    private Integer reference;

    public TransferModel() {
    }

    public TransferModel(AccountModel fromAccountModel, AccountModel toAccountModel, Integer amount, LocalDateTime dateTime, Integer reference) {
        this.fromAccountModel = fromAccountModel;
        this.toAccountModel = toAccountModel;
        this.amount = amount;
        this.dateTime = dateTime;
        this.reference = reference;
    }

    public AccountModel getFromAccount() {
        return fromAccountModel;
    }

    public void setFromAccount(AccountModel fromAccountModel) {
        this.fromAccountModel = fromAccountModel;
    }

    public AccountModel getToAccount() {
        return toAccountModel;
    }

    public void setToAccount(AccountModel toAccountModel) {
        this.toAccountModel = toAccountModel;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getReference() {
        return reference;
    }

    public void setReference(Integer reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "TransferModel{" +
                "actor=" + getActor() +
                ", fromCard=" + fromAccountModel +
                ", toCard=" + toAccountModel +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", reference=" + reference +
                ", happenedAt=" + getHappenedAt() +
                '}';
    }
}
