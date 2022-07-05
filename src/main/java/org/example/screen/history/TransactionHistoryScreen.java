package org.example.screen.history;

import org.example.model.BalanceInquiryModel;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;
import org.example.repository.TransactionRepository;
import org.example.screen.contract.ScreenContract;

import java.util.stream.IntStream;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.components.PrinterComponent.*;
import static org.example.data.AppData.loggedInCard;
import static org.example.data.AppData.scanner;
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
        var transactions = TransactionRepository.getMyLast10Transactions(loggedInCard.getId());
        if (transactions.isEmpty()) {
            printMessage("No transactions found");
            return;
        }

        IntStream.range(0, transactions.size())
                .forEach(index -> {
                    var transaction = transactions.get(index);
                    var number = index + 1;

                    if (transaction instanceof WithdrawModel withdraw) {
                        printWithdraw(number, withdraw);
                    } else if (transaction instanceof BalanceInquiryModel balance) {
                        printBalance(number, balance);
                    } else if (transaction instanceof TransferModel transfer) {
                        printTransfer(number, transfer);
                    }
                });
    }
}
