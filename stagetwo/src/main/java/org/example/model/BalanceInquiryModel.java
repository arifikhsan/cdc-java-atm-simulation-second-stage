package org.example.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class BalanceInquiryModel extends Transaction {
    private Integer balance;
    private AccountModel account;

    public BalanceInquiryModel(Integer balance, AccountModel account) {
        this.balance = balance;
        this.account = account;
    }

    public BalanceInquiryModel(UUID id, AccountModel actor, LocalDateTime happenedAt, Integer balance, AccountModel account) {
        super(id, actor, happenedAt);
        this.balance = balance;
        this.account = account;
    }

    public BalanceInquiryModel() {
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "BalanceInquiryModel{" +
                "actor=" + getActor() +
                "balance=" + balance +
                ", card=" + account +
                ", happenedAt=" + getHappenedAt() +
                '}';
    }
}
