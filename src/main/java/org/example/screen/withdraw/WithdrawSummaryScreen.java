package org.example.screen.withdraw;

import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.Main.*;
import static org.example.components.MessageComponent.*;
import static org.example.util.SystemUtil.*;

public class WithdrawSummaryScreen implements ScreenContract {
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
                    return;
                }
                case 2 -> exitApp();
                default -> printInvalidOptionMessage(option);
            }
        }
    }

    private void showSummaryDetailMessage() {
        println("Summary");
        println("Date: " + withdrawModel.getDatetime().format(dateTimeFormatter));
        println("Withdraw amount: $ " + withdrawModel.getAmount());
        println("Current Balance: $ " + withdrawModel.getCard().getBalance());
    }

    private void showOptionsMessage() {
        printHorizontalLine();
        println("1. Back");
        println("2. Exit");
        printHorizontalLine();
        print("Select Transaction [2]: ");
    }

    private Boolean isInvalidInput(String input) {
        return !input.matches("[1-2]");
    }
}
