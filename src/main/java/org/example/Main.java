package org.example;

import org.example.model.CardModel;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;
import org.example.repository.CardRepository;
import org.example.repository.TransferRepository;
import org.example.repository.WithdrawRepository;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.example.router.Router.gotoWelcomeScreen;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static CardModel loggedInCard = null;
    public static WithdrawModel withdrawModel = new WithdrawModel();
    public static TransferModel transferModel = new TransferModel();
    public static CardRepository cardRepository = new CardRepository();
    public static WithdrawRepository withdrawRepository = new WithdrawRepository();
    public static TransferRepository transferRepository = new TransferRepository();
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");

    public static void main(String[] args) {
        gotoWelcomeScreen();
    }
}
