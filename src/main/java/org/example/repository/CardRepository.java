package org.example.repository;

import org.example.data.AccountData;
import org.example.model.AccountModel;

import java.util.List;

public class CardRepository {
    private List<AccountModel> accountModels = AccountData.getCardsFromCSV();

    public List<AccountModel> getAccounts() {
        return accountModels;
    }

    public void setAccounts(List<AccountModel> accountModels) {
        this.accountModels = accountModels;
    }

    public AccountModel getAccountByNumber(String accountNumber) {
        return accountModels.stream()
                .filter(account -> account.getNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public boolean isExistByCardNumber(String accountNumber) {
        return accountModels.stream().anyMatch(account -> account.getNumber().equals(accountNumber));
    }

    public boolean isExistByCardNumberAndPin(String accountNumber, String pin) {
        return accountModels.stream().anyMatch(account -> account.getNumber().equals(accountNumber) && account.getPin().equals(pin));
    }
}
