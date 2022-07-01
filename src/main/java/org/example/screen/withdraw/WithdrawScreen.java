package org.example.screen.withdraw;

import org.example.model.WithdrawModel;
import org.example.screen.contract.ScreenContract;

import java.time.LocalDateTime;

import static java.lang.Integer.parseInt;
import static org.example.Main.*;
import static org.example.components.MessageComponent.*;
import static org.example.router.Router.gotoWithdrawCustomScreen;
import static org.example.router.Router.gotoWithdrawSummaryScreen;
import static org.example.util.SystemUtil.*;

public class WithdrawScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printWithdrawMessage();
            showBalanceMessage();
            showOptionsMessage();

            var option = scanner.nextLine();
            if (option.isEmpty()) option = "5";

            if (isInvalidInput(option)) {
                printInvalidOptionMessage(option);
                continue;
            }

            switch (parseInt(option)) {
                case 1 -> withdraw(10);
                case 2 -> withdraw(50);
                case 3 -> withdraw(100);
                case 4 -> {
                    gotoWithdrawCustomScreen();
                    return;
                }
                case 5 -> {
                    return;
                }
                default -> printInvalidOptionMessage(option);
            }
        }
    }

    private void withdraw(Integer amount) {
        if (!isBalanceEnough(amount)) {
            printErrorMessage("Insufficient withdraw balance $" + amount + ". Current balance is $" + loggedInCard.getBalance());
            return;
        }

        saveWithdrawData(amount);
        printEmptyLine();
        printSuccessMessage("Withdraw success!");
        gotoWithdrawSummaryScreen();
    }

    private void saveWithdrawData(Integer amount) {
        loggedInCard.setBalance(loggedInCard.getBalance() - amount);
        withdrawModel = new WithdrawModel(LocalDateTime.now(), amount, loggedInCard.getBalance(), loggedInCard);
        withdrawRepository.getWithdraws().add(withdrawModel);
    }

    private Boolean isBalanceEnough(Integer amount) {
        return loggedInCard.getBalance() >= amount;
    }

    private void showBalanceMessage() {
        printHorizontalLine();
        println("Your balance: $ " + loggedInCard.getBalance());
        printHorizontalLine();
    }

    private void showOptionsMessage() {
        printHorizontalLine();
        println("1. $10");
        println("2. $50");
        println("3. $100");
        println("4. Other");
        println("5. Back");
        printHorizontalLine();
        print("Select Transaction [5]: ");
    }

    private Boolean isInvalidInput(String input) {
        return !input.matches("[1-5]");
    }
}
