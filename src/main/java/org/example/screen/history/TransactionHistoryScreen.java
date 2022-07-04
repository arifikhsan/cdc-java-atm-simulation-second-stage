package org.example.screen.history;

import org.example.model.BalanceInquiryModel;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;
import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.components.PrinterComponent.*;
import static org.example.data.AppData.*;
import static org.example.util.SystemUtil.*;

@SuppressWarnings("DuplicatedCode")
public class TransactionHistoryScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printTransactionHistoryMessage();
            printTransactionHistory();
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

    private void printTransactionHistory() {
        var transactions = transactionRepository.getMyLast10Transactions(loggedInCard);
        if (transactions.isEmpty()) {
            printMessage("No transactions found");
            return;
        }

        transactions.forEach(transaction -> {
                    if (transaction instanceof WithdrawModel withdraw) {
                        printWithdraw(withdraw);
                    } else if (transaction instanceof BalanceInquiryModel balance) {
                        printBalance(balance);
                    } else if (transaction instanceof TransferModel transfer) {
                        printTransfer(transfer);
                    }
                });
    }
}
