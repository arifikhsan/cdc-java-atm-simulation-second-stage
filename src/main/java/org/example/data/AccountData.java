package org.example.data;

import org.example.model.AccountModel;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountData {
    public static List<AccountModel> getAllCards() {
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

    public static List<AccountModel> getCardsFromCSV() {
        var filename = "src/main/resources/accounts.csv";
        var accounts = new ArrayList<AccountModel>();

        try (var scanner = new Scanner(Paths.get(filename))) {
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                var parts = line.split(",");
                var name = parts[0];
                var number = parts[1];
                var pin = parts[2];
                var balance = Integer.parseInt(parts[3]);

                if (accounts.stream().anyMatch(card -> card.getNumber().equals(number))) {
                    throw new RuntimeException("There can't be multiple accounts with the same Account Number. Number: " + number);
                }

                var newAccount = new AccountModel();
                newAccount.setName(name);
                newAccount.setNumber(number);
                newAccount.setPin(pin);
                newAccount.setBalance(balance);

                if (accounts.stream().anyMatch(account -> account.equals(newAccount))) {
                    throw new RuntimeException("There can't be duplicated records. Record: " + newAccount);
                }

                accounts.add(newAccount);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return accounts;
    }
}
