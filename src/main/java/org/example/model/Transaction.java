package org.example.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Transaction {
    private UUID id;
    private AccountModel actor;
    private LocalDateTime happenedAt;

    public Transaction() {
    }

    public Transaction(AccountModel actor, LocalDateTime happenedAt) {
        this.actor = actor;
        this.happenedAt = happenedAt;
    }

    public Transaction(UUID id, AccountModel actor, LocalDateTime happenedAt) {
        this.id = id;
        this.actor = actor;
        this.happenedAt = happenedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
