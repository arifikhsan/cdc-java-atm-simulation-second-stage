package org.example.repository;

import org.example.model.AccountModel;
import org.example.model.Transaction;
import org.example.model.TransferModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository() {
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transaction> getMyLast10Transactions(AccountModel account) {
        return transactions.stream()
                .filter(transaction -> {
                    // get withdraw and balance inquiry transactions
                    var personalTransaction =  transaction.getActor().equals(account);

                    // get transfer from other account transactions
                    if (transaction instanceof TransferModel transfer) {
                        var toAccount = transfer.getToAccount();
                        var transferFromOtherAccount = toAccount.equals(account);
                        return personalTransaction || transferFromOtherAccount;
                    }

                    return personalTransaction;
                })
                .sorted(comparing(Transaction::getHappenedAt).reversed()) // sort by happenedAt desc
                .limit(10)
                .sorted(comparing(Transaction::getHappenedAt)) // sort by happenedAt asc
                .toList();
    }
}
