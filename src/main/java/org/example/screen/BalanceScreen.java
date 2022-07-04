package org.example.screen;

import org.example.model.BalanceInquiryModel;
import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.Main.*;
import static org.example.components.MessageComponent.*;
import static org.example.components.MessageComponent.printInvalidOptionMessage;
import static org.example.util.SystemUtil.*;
import static org.example.util.TimeUtil.getCurrentTime;

@SuppressWarnings("DuplicatedCode")
public class BalanceScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printBalanceMessage();
            printBalance();
            saveBalanceInquiryToTransaction();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty()) option = "2";

            if (!isValidInput(option)) {
                printInvalidOptionMessage(option);
                continue;
            }

            switch (parseInt(option)) {
                case 1 -> {
                    return;
                }
                case 2 -> {
                }
                default -> printInvalidOptionMessage(option);
            }
        }
    }

    private void showOptionMessage() {
        printHorizontalLine();
        println("1. Back");
        println("2. Do nothing");
        printHorizontalLine();
        print("Select option [2]: ");
    }

    private Boolean isValidInput(String input) {
        return input.matches("[1-2]");
    }

    private void printBalance() {
        println("Account");
        println("Name: " + loggedInCard.getName());
        println("Number: " + loggedInCard.getNumber());
        println("Balance: $" + loggedInCard.getBalance());
    }

    private void saveBalanceInquiryToTransaction() {
        var balance = new BalanceInquiryModel();
        balance.setActor(loggedInCard);
        balance.setHappenedAt(getCurrentTime());
        balance.setCard(loggedInCard);
        balance.setBalance(loggedInCard.getBalance());
        transactionRepository.getTransactions().add(balance);
    }
}
