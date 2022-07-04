package org.example.screen;

import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.loggedInCard;
import static org.example.data.AppData.scanner;
import static org.example.router.Router.*;
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

            if (!isValidInput(option)) {
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
                    gotoBalanceScreen();
                    continue;
                }
                case 4: {
                    gotoTransactionHistoryScreen();
                    continue;
                }
                case 5: {
                    loggedInCard = null;
                    return;
                }
                case 6: exitApp();
                case 7: {
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
        println("3. Check Balance");
        println("4. Transaction History");
        println("5. Logout");
        println("6. Exit");
        println("7. Do nothing");
        printHorizontalLine();
        print("Select transaction [7]: ");
    }

    private Boolean isValidInput(String input) {
        return input.matches("[1-7]");
    }
}
