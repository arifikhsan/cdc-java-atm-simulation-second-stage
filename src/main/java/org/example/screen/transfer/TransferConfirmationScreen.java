package org.example.screen.transfer;

import org.example.repository.TransferRepository;
import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.*;
import static org.example.util.NumberUtil.isAStringNumber;
import static org.example.util.NumberUtil.isPositive;
import static org.example.util.SystemUtil.*;

public class TransferConfirmationScreen extends ScreenContract {
    private static final Integer DEFAULT_CHOICE = 2;

    private void showSummary() {
        printHorizontalLine();
        println("Destination Account: " + transferModel.getToAccount().getNumber());
        println("Amount: $" + transferModel.getAmount());
        println("Reference Number: " + transferModel.getReference());
        printHorizontalLine();
    }

    private void showOptionMessage() {
        printHorizontalLine();
        printEmptyLine();
        println("1. Confirm Transaction");
        println("2. Cancel Transaction");
        printEmptyLine();
        printHorizontalLine();
        print("Choose option ["+DEFAULT_CHOICE+"]: ");
    }

    private boolean isIncludedInOption(String option) {
        return option.matches("[1-3]");
    }

    @Override
    public void show() {
        while (true) {
            printTransferConfirmationMessage();
            showSummary();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty()) option = DEFAULT_CHOICE.toString();

            if (!isValidOption(option)) {
                printInvalidInputMessage();
                continue;
            }

            if (parseInt(option) == 1) {
                transferMoney();
                printSuccessMessage("Transfer successful");
                currentScreen = transferSummary;
                return;
            }

            currentScreen = transaction;
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
}
