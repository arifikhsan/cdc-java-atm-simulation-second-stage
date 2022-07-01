package org.example.screen.transfer;

import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.Main.*;
import static org.example.components.MessageComponent.*;
import static org.example.util.NumberUtil.isAStringNumber;
import static org.example.util.NumberUtil.isPositive;
import static org.example.util.SystemUtil.*;

public class TransferSummaryScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printTransferSummaryMessage();
            showSummary();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty()) option = "2";

            if (!isValidOption(option)) {
                printInvalidInputMessage();
                continue;
            }

            if (parseInt(option) == 2) {
                exitApp();
            }

            return;
        }

    }

    private boolean isValidOption(String option) {
        return isAStringNumber(option) && isPositive(parseInt(option)) && isIncludedInOption(option);
    }

    private boolean isIncludedInOption(String option) {
        return option.matches("[1-2]");
    }

    private void showOptionMessage() {
        printHorizontalLine();
        println("1. Back to Transaction");
        println("2. Exit");
        printHorizontalLine();
        print("Choose option [2]: ");
    }

    private void showSummary() {
        printHorizontalLine();
        println("Destination Account: " + transferModel.getToAccount().getNumber());
        println("Amount: $" + transferModel.getAmount());
        println("Reference Number: " + transferModel.getReference());
        println("Current Balance: $" + loggedInCard.getBalance());
        println("Date: " + transferModel.getDateTime().format(dateTimeFormatter));
        printHorizontalLine();
    }
}
