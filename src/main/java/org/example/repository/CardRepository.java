package org.example.repository;

import org.example.data.CardData;
import org.example.model.CardModel;

import java.util.List;

public class CardRepository {
    private List<CardModel> cards = CardData.getAllCards();

    public List<CardModel> getCards() {
        return cards;
    }

    public void setCards(List<CardModel> cards) {
        this.cards = cards;
    }

    public CardModel getCardByNumber(String cardNumber) {
        return cards.stream()
                .filter(card -> card.getNumber().equals(cardNumber))
                .findFirst()
                .orElse(null);
    }

    public boolean isExistByCardNumber(String cardNumber) {
        return cards.stream().anyMatch(card -> card.getNumber().equals(cardNumber));
    }

    public boolean isExistByCardNumberAndPin(String cardNumber, String pin) {
        return cards.stream().anyMatch(card -> card.getNumber().equals(cardNumber) && card.getPin().equals(pin));
    }
}
