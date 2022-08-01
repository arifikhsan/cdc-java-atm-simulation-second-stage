package org.example.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class WithdrawModel extends Transaction {
    private Integer amount;
    private Integer balance;
    private LocalDateTime datetime;
    private AccountModel account;

    public WithdrawModel(UUID id, AccountModel actor, LocalDateTime happenedAt, Integer amount, Integer balance, LocalDateTime datetime, AccountModel account) {
        super(id, actor, happenedAt);
        this.amount = amount;
        this.balance = balance;
        this.datetime = datetime;
        this.account = account;
    }

    public WithdrawModel() {
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        return "WithdrawModel{" +
                "actor=" + getActor() +
                ", datetime=" + datetime +
                ", amount=" + amount +
                ", balance=" + balance +
                ", card=" + account +
                ", happenedAt=" + getHappenedAt() +
                '}';
    }
}
