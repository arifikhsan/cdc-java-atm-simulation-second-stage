package org.example.screen;

import org.example.model.BalanceInquiryModel;
import org.example.repository.BalanceRepository;
import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.loggedInCard;
import static org.example.data.AppData.scanner;
import static org.example.util.SystemUtil.*;

@SuppressWarnings("DuplicatedCode")
public class BalanceScreen extends ScreenContract {
    private static final Integer DEFAULT_CHOICE = 1;

    private void printBalance() {
        println("Account");
        println("Name: " + loggedInCard.getName());
        println("Number: " + loggedInCard.getNumber());
        println("Balance: $" + loggedInCard.getBalance());
    }

    private void showOptionMessage() {
        printHorizontalLine();
        println("1. Back");
        printHorizontalLine();
        print("Select option [1]: ");
    }

    private Boolean isValidInput(String input) {
        return input.matches("1");
    }

    @Override
    public void show() {
        while (true) {
            printBalanceMessage();
            printBalance();
            saveBalanceInquiryToTransaction();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty()) option = DEFAULT_CHOICE.toString();

            if (!isValidInput(option)) {
                printInvalidOptionMessage(option);
                continue;
            }

            if (parseInt(option) == 1) {
                currentScreen = transaction;
                return;
            } else {
                printInvalidOptionMessage(option);
            }
        }
    }

    private void saveBalanceInquiryToTransaction() {
        var balance = new BalanceInquiryModel();
        balance.setActor(loggedInCard);
        balance.setAccount(loggedInCard);
        balance.setBalance(loggedInCard.getBalance());
        BalanceRepository.save(balance);
    }
}
