package org.example.model;

import java.time.LocalDateTime;

public abstract class Transaction {
    private AccountModel actor;
    private LocalDateTime happenedAt;

    public Transaction() {
    }

    public Transaction(AccountModel actor, LocalDateTime happenedAt) {
        this.actor = actor;
        this.happenedAt = happenedAt;
    }

    public AccountModel getActor() {
        return actor;
    }

    public void setActor(AccountModel actor) {
        this.actor = actor;
    }

    public LocalDateTime getHappenedAt() {
        return happenedAt;
    }

    public void setHappenedAt(LocalDateTime happenedAt) {
        this.happenedAt = happenedAt;
    }
}
