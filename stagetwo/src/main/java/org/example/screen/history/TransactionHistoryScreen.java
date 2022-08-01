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
public class TransactionHistoryScreen extends ScreenContract {
    private static final Integer DEFAULT_CHOICE = 1;

    private void showOptionMessage() {
        printHorizontalLine();
        println("1. Back");
        printHorizontalLine();
        print("Select option ["+DEFAULT_CHOICE+"]: ");
    }

    private Boolean isValidInput(String input) {
        return input.matches(DEFAULT_CHOICE.toString());
    }

    @Override
    public void show() {
        while (true) {
            printTransactionHistoryMessage();
            printTransactionHistory();
            showOptionMessage();

            var option = scanner.nextLine();
            printEmptyLine();

            if (option.isEmpty() || parseInt(option) == DEFAULT_CHOICE) {
                currentScreen = transaction;
                return;
            }

            if (!isValidInput(option)) {
                printInvalidOptionMessage(option);
            }
        }
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
