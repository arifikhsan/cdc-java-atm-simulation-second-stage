package org.example;

import org.example.model.Transaction;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        var transfer = new TransferModel();
        var withdraw = new WithdrawModel();

        var transactions = new ArrayList<Transaction>();
        transactions.add(transfer);
        transactions.add(withdraw);
        transactions.forEach(Example::printTransaction);
    }

    public static void printTransaction(Transaction transaction) {
        System.out.println(transaction);
    }
}
