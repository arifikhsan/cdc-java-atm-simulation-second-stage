package org.example.model;

import java.util.Objects;
import java.util.UUID;

public class AccountModel {
    private UUID id;
    private String name;
    private String number;
    private String pin;
    private Integer balance;

    public AccountModel(String name, String number, String pin, Integer balance) {
        this.name = name;
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }

    public AccountModel(UUID id, String name, String number, String pin, Integer balance) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.pin = pin;
        this.balance = balance;
    }

    public AccountModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public synchronized Integer getBalance() {
        return balance;
    }

    public synchronized void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountModel accountModel = (AccountModel) o;
        return Objects.equals(name, accountModel.name) && Objects.equals(number, accountModel.number) && Objects.equals(pin, accountModel.pin) && Objects.equals(balance, accountModel.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, pin, balance);
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", pin='" + pin + '\'' +
                ", balance=" + balance +
                '}';
    }
}
