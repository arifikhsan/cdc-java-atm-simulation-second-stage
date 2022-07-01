package org.example.data;

import org.example.model.CardModel;

import java.util.List;

public class CardData {
    public static List<CardModel> getAllCards() {
        var card1 = new CardModel();
        card1.setName("John Doe");
        card1.setNumber("111111");
        card1.setPin("111111");
        card1.setBalance(100);

        var card2 = new CardModel();
        card2.setName("Jane Doe");
        card2.setNumber("222222");
        card2.setPin("222222");
        card2.setBalance(30);

        return List.of(card1, card2);
    }
}

// Name: John Doe
// PIN: 012108
// Balance: $100
// Account Number: 112233
//
// Name: Jane Doe
// PIN: 932012
// Balance: $30
// Account Number: 112244
