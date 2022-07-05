package org.example.repository;

import org.example.model.AccountModel;
import org.example.model.Transaction;
import org.example.model.TransferModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Comparator.comparing;

public class TransactionRepository {
    public TransactionRepository() {
    }

    public static List<Transaction> getTransactions() {
        var balanceInquiries = BalanceRepository.getInquiries();
        var withdraws = WithdrawRepository.getWithdraws();
        var transfers = TransferRepository.getTransfers();

        var transactions = new ArrayList<Transaction>();
        transactions.addAll(balanceInquiries);
        transactions.addAll(withdraws);
        transactions.addAll(transfers);
        return transactions;
    }

    public static List<Transaction> getMyLast10Transactions(UUID accountId) {
        return getTransactions().stream()
                .filter(transaction -> {
                    // get withdraw and balance inquiry transactions
                    var personalTransaction =  transaction.getActor().getId().equals(accountId);

                    // get transfer from other account transactions
                    if (transaction instanceof TransferModel transfer) {
                        var toAccount = transfer.getToAccount();
                        var transferFromOtherAccount = toAccount.getId().equals(accountId);
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
