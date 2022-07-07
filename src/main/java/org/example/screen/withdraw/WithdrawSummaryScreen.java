package org.example.screen.withdraw;

import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.*;
import static org.example.util.SystemUtil.*;

public class WithdrawSummaryScreen extends ScreenContract {
    private static final Integer DEFAULT_CHOICE = 2;

    private void showSummaryDetailMessage() {
        println("Summary");
        println("Date: " + withdrawModel.getDatetime().format(dateTimeFormatter));
        println("Withdraw amount: $ " + withdrawModel.getAmount());
        println("Current Balance: $ " + withdrawModel.getAccount().getBalance());
    }

    private void showOptionsMessage() {
        printHorizontalLine();
        println("1. Transaction");
        println("2. Exit");
        printHorizontalLine();
        print("Select Transaction [" + DEFAULT_CHOICE + "]: ");
    }

    private Boolean isInvalidInput(String input) {
        return !input.matches("[1-2]");
    }

    @Override
    public void show() {
        while (true) {
            printWithdrawSummaryMessage();
            showSummaryDetailMessage();
            showOptionsMessage();

            var option = scanner.nextLine();
            if (option.isEmpty()) option = "2";

            if (isInvalidInput(option)) {
                printInvalidOptionMessage(option);
                continue;
            }

            switch (parseInt(option)) {
                case 1 -> {
                    currentScreen = transaction;
                    return;
                }
                case 2 -> {
                    currentScreen = welcome;
                    return;
                }
                default -> printInvalidOptionMessage(option);
            }
        }
    }
}
