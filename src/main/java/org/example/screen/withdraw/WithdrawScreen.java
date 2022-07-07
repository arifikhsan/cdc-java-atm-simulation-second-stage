package org.example.screen.withdraw;

import org.example.model.WithdrawModel;
import org.example.repository.WithdrawRepository;
import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.*;
import static org.example.util.SystemUtil.*;
import static org.example.util.TimeUtil.getCurrentTime;

@SuppressWarnings("DuplicatedCode")
public class WithdrawScreen extends ScreenContract {
    private static final Integer DEFAULT_CHOICE = 5;

    private void showOptionsMessage() {
        printHorizontalLine();
        println("1. $10");
        println("2. $50");
        println("3. $100");
        println("4. Other");
        println("5. Back");
        printHorizontalLine();
        print("Select Transaction [" + DEFAULT_CHOICE + "]: ");
    }

    private Boolean isInvalidInput(String input) {
        return !input.matches("[1-5]");
    }

    @Override
    public void show() {
        while (true) {
            printWithdrawMessage();
            showBalanceMessage();
            showOptionsMessage();

            var option = scanner.nextLine();
            if (option.isEmpty()) option = DEFAULT_CHOICE.toString();

            if (isInvalidInput(option)) {
                printInvalidOptionMessage(option);
                continue;
            }

            switch (parseInt(option)) {
                case 1 -> {
                    withdraw(10);
                    return;
                }
                case 2 -> {
                    withdraw(50);
                    return;
                }
                case 3 -> {
                    withdraw(100);
                    return;
                }
                case 4 -> {
                    currentScreen = otherWithdraw;
                    return;
                }
                case 5 -> {
                    currentScreen = transaction;
                    return;
                }
                default -> printInvalidOptionMessage(option);
            }
        }
    }

    private void withdraw(Integer amount) {
        if (!isBalanceEnough(amount)) {
            printErrorMessage("Insufficient withdraw balance $" + amount);
            return;
        }

        saveWithdrawData(amount);
        printEmptyLine();
        printSuccessMessage("Withdraw success!");
        currentScreen = summaryWithdraw;
    }

    private void saveWithdrawData(Integer amount) {
        loggedInCard.setBalance(loggedInCard.getBalance() - amount);
        withdrawModel = new WithdrawModel();
        withdrawModel.setActor(loggedInCard);
        withdrawModel.setAccount(loggedInCard);
        withdrawModel.setAmount(amount);
        withdrawModel.setBalance(loggedInCard.getBalance());
        withdrawModel.setDatetime(getCurrentTime());
        WithdrawRepository.save(withdrawModel);
    }

    private Boolean isBalanceEnough(Integer amount) {
        return loggedInCard.getBalance() >= amount;
    }

    private void showBalanceMessage() {
        printHorizontalLine();
        println("Your balance: $ " + loggedInCard.getBalance());
        printHorizontalLine();
    }
}
