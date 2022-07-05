package org.example.screen.transfer;

import org.example.repository.TransferRepository;
import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.*;
import static org.example.router.Router.gotoSummaryScreen;
import static org.example.util.NumberUtil.isAStringNumber;
import static org.example.util.NumberUtil.isPositive;
import static org.example.util.SystemUtil.*;

public class TransferConfirmationScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printTransferConfirmationMessage();
            showSummary();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty()) option = "2";

            if (!isValidOption(option)) {
                printInvalidInputMessage();
                continue;
            }

            if (parseInt(option) == 1) {
                transferMoney();
                printSuccessMessage("Transfer successful");
                gotoSummaryScreen();
            }

            return;
        }
    }

    private void transferMoney() {
        transferModel.setActor(loggedInCard);
        TransferRepository.save(transferModel);

        // move money from source account to destination account
        loggedInCard.setBalance(loggedInCard.getBalance() - transferModel.getAmount());
        transferModel.getToAccount().setBalance(transferModel.getToAccount().getBalance() + transferModel.getAmount());
    }

    private boolean isValidOption(String option) {
        return isAStringNumber(option) && isPositive(parseInt(option)) && isIncludedInOption(option);
    }

    private boolean isIncludedInOption(String option) {
        return option.matches("[1-3]");
    }

    private void showOptionMessage() {
        printHorizontalLine();
        println();
        println("1. Confirm Transaction");
        println("2. Cancel Transaction");
        println();
        printHorizontalLine();
        print("Choose option [2]: ");
    }

    private void showSummary() {
        printHorizontalLine();
        println("Destination Account: " + transferModel.getToAccount().getNumber());
        println("Amount: $" + transferModel.getAmount());
        println("Reference Number: " + transferModel.getReference());
        printHorizontalLine();
    }
}
