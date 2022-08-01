package org.example.repository;

import org.example.model.AccountModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class AccountRepository {
    private static final Path path = Paths.get("src/main/resources/accounts.csv");
    private static final Path initialPath = Paths.get("src/main/resources/initial-accounts.csv");

    public static List<AccountModel> getAccounts() {
        return getAccountsStream().toList();
    }

    public static AccountModel getAccountByNumber(String accountNumber) {
        return getAccountsStream()
                .filter(account -> account.getNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public static AccountModel getAccountById(UUID id) {
        return getAccountsStream()
                .filter(account -> account.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static boolean isExistByCardNumber(String accountNumber) {
        return getAccountsStream().anyMatch(account -> account.getNumber().equals(accountNumber));
    }

    public static boolean isExistByCardNumberAndPin(String accountNumber, String pin) {
        return getAccountsStream().anyMatch(account -> account.getNumber().equals(accountNumber) && account.getPin().equals(pin));
    }

    public static void validateAccounts() {
        var accounts = new ArrayList<AccountModel>();
        getAccountsStream()
                .forEach(newAccount -> {
                    if (accounts.stream().anyMatch(account -> account.getNumber().equals(newAccount.getNumber()))) {
                        throw new RuntimeException("There can't be multiple accounts with the same Account Number. Number: " + newAccount.getNumber());
                    }

                    if (accounts.stream().anyMatch(account -> account.equals(newAccount))) {
                        throw new RuntimeException("There can't be duplicated records. Record: " + newAccount);
                    }

                    accounts.add(newAccount);
                });
    }

    private static Stream<AccountModel> getAccountsStream() {
        try {
            return Files.readAllLines(path)
                    .stream()
                    .skip(1)
                    .map(text -> text.split(","))
                    .map(parts -> {
                        var id = UUID.fromString(parts[0]);
                        var name = parts[1];
                        var number = parts[2];
                        var pin = parts[3];
                        var balance = Integer.parseInt(parts[4]);
                        return new AccountModel(id, name, number, pin, balance);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void resetContents() {
        try {
            Files.copy(initialPath, path, REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// TODO: update row in csv file