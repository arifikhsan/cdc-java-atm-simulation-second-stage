package org.example.data;

import org.example.model.AccountModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AccountData {
    public static List<AccountModel> getAllAccounts() {
        var card1 = new AccountModel();
        card1.setName("John Doe");
        card1.setNumber("111111");
        card1.setPin("111111");
        card1.setBalance(100);

        var card2 = new AccountModel();
        card2.setName("Jane Doe");
        card2.setNumber("222222");
        card2.setPin("222222");
        card2.setBalance(30);

        return List.of(card1, card2);
    }
}
