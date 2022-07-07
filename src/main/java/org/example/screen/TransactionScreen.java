package org.example.screen;

import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.loggedInCard;
import static org.example.data.AppData.scanner;
import static org.example.util.SystemUtil.*;

public class TransactionScreen extends ScreenContract {
    private static final Integer DEFAULT_CHOICE = 5;

    private void showOptionMessage() {
        printHorizontalLine();
        println("1. Withdraw");
        println("2. Fund Transfer");
        println("3. Check Balance");
        println("4. Transaction History");
        println("5. Exit"); // to login screen
        printHorizontalLine();
        print("Select transaction ["+DEFAULT_CHOICE+"]: ");
    }

    private Boolean isValidInput(String input) {
        return input.matches("[1-5]");
    }

    @Override
    public void show() {
        while (true) {
            printTransactionMessage();
            showUserInfo();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty()) option = DEFAULT_CHOICE.toString();

            if (!isValidInput(option)) {
                printInvalidOptionMessage(option);
                continue;
            }

            switch (parseInt(option)) {
                case 1 -> {
                    currentScreen = withdraw;
                    return;
                }
                case 2 -> {
                    currentScreen = transferInputAccount;
                    return;
                }
                case 3 -> {
                    currentScreen = checkBalance;
                    return;
                }
                case 4 -> {
                    currentScreen = transactionHistory;
                    return;
                }
                case 5 -> {
                    currentScreen = welcome;
                    return;
                }
                default -> printInvalidOptionMessage(option);
            }
        }
    }

    private void showUserInfo() {
        printHorizontalLine();
        println("Name: " + loggedInCard.getName());
        println("Account Number: " + loggedInCard.getNumber());
        println("Balance: $" + loggedInCard.getBalance());
        printHorizontalLine();
    }
}
