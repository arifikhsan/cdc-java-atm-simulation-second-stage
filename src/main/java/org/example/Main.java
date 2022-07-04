package org.example;

import org.example.model.AccountModel;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;
import org.example.repository.CardRepository;
import org.example.repository.TransactionRepository;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.example.router.Router.gotoWelcomeScreen;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static AccountModel loggedInCard = null;
    public static WithdrawModel withdrawModel = new WithdrawModel();
    public static TransferModel transferModel = new TransferModel();
    public static CardRepository cardRepository = new CardRepository();
    public static TransactionRepository transactionRepository = new TransactionRepository();
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");

    public static void main(String[] args) {
        gotoWelcomeScreen();
    }
}
