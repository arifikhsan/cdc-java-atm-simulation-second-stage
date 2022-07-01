package org.example.model;

public class CardModel {
    private String name;
    private String number;
    private String pin;
    private Integer balance;

    public CardModel() {
    }

    public CardModel(String name, String number, String pin, Integer balance) {
        this.name = name;
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
