package org.example.model;

public class BalanceInquiryModel extends Transaction {
    private Integer balance;
    private AccountModel card;

    public BalanceInquiryModel(Integer balance, AccountModel card) {
        this.balance = balance;
        this.card = card;
    }

    public BalanceInquiryModel() {
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public AccountModel getCard() {
        return card;
    }

    public void setCard(AccountModel card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "BalanceInquiryModel{" +
                "actor=" + getActor() +
                "balance=" + balance +
                ", card=" + card +
                ", happenedAt=" + getHappenedAt() +
                '}';
    }
}
