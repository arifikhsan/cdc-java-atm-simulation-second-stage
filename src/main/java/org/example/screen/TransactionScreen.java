package org.example.screen;

import org.example.screen.contract.ScreenContract;
import static java.lang.Integer.parseInt;
import static org.example.Main.loggedInCard;
import static org.example.Main.scanner;
import static org.example.components.MessageComponent.*;
import static org.example.router.Router.gotoTransferScreen;
import static org.example.router.Router.gotoWithdrawScreen;
import static org.example.util.SystemUtil.*;

public class TransactionScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printTransactionMessage();
            showUserInfo();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty()) option = "5";

            if (isInvalidInput(option)) {
                printInvalidOptionMessage(option);
                continue;
            }

            switch (parseInt(option)) {
                case 1: {
                    gotoWithdrawScreen();
                    continue;
                }
                case 2: {
                    gotoTransferScreen();
                    continue;
                }
                case 3: {
                    loggedInCard = null;
                    return;
                }
                case 4: exitApp();
                case 5: {
                    continue;
                }
                default: {
                    printInvalidOptionMessage(option);
                }
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

    private void showOptionMessage() {
        printHorizontalLine();
        println("1. Withdraw");
        println("2. Transfer");
        println("3. Logout");
        println("4. Exit");
        println("5. Do nothing");
        printHorizontalLine();
        print("Select transaction [5]: ");
    }

    private Boolean isInvalidInput(String input) {
        return !input.matches("[1-5]");
    }
}
