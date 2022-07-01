package org.example.model;

import java.time.LocalDateTime;

public class TransferModel {
    private CardModel fromCard;
    private CardModel toCard;
    private Integer amount;
    private LocalDateTime dateTime;
    private Integer reference;

    public TransferModel() {
    }

    public TransferModel(CardModel fromCard, CardModel toCard, Integer amount, LocalDateTime dateTime, Integer reference) {
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.amount = amount;
        this.dateTime = dateTime;
        this.reference = reference;
    }

    public CardModel getFromCard() {
        return fromCard;
    }

    public void setFromCard(CardModel fromCard) {
        this.fromCard = fromCard;
    }

    public CardModel getToCard() {
        return toCard;
    }

    public void setToCard(CardModel toCard) {
        this.toCard = toCard;
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
}
