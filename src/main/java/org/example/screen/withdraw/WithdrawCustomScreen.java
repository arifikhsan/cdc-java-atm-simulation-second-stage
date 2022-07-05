package org.example.screen.withdraw;

import org.example.model.WithdrawModel;
import org.example.repository.WithdrawRepository;
import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.components.MessageComponent.*;
import static org.example.data.AppData.*;
import static org.example.router.Router.gotoWithdrawSummaryScreen;
import static org.example.util.NumberUtil.isGreaterThan1000;
import static org.example.util.NumberUtil.isMultiplyOf10;
import static org.example.util.StringUtil.isValidAmountOfMoney;
import static org.example.util.SystemUtil.print;
import static org.example.util.SystemUtil.printEmptyLine;
import static org.example.util.TimeUtil.getCurrentTime;

@SuppressWarnings("DuplicatedCode")
public class WithdrawCustomScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printWithdrawCustomMessage();
            print("Enter amount to withdraw: ");

            var amount = scanner.nextLine();

            if (!isValidAmountOfMoney(amount)) {
                printErrorMessage("Invalid amount");
                continue;
            }

            var withdrawAmount = parseInt(amount);

            if (isGreaterThan1000(withdrawAmount)) {
                printErrorMessage("Maximum amount to withdraw is $1000");
                continue;
            }

            if (!isBalanceEnough(withdrawAmount)) {
                printErrorMessage("Insufficient balance $" + withdrawAmount + ". Current balance is $" + loggedInCard.getBalance());
                continue;
            }

            if (!isMultiplyOf10(withdrawAmount)) {
                printErrorMessage("Amount must be multiple of 10");
                continue;
            }

            withdraw(withdrawAmount);
            return;
        }
    }

    private void withdraw(int amount) {
        saveWithdrawData(amount);
        printEmptyLine();
        printSuccessMessage("Withdraw success!");
        gotoWithdrawSummaryScreen();
    }

    private void saveWithdrawData(int amount) {
        loggedInCard.setBalance(loggedInCard.getBalance() - amount);
        withdrawModel = new WithdrawModel();
        withdrawModel.setActor(loggedInCard);
        withdrawModel.setAccount(loggedInCard);
        withdrawModel.setAmount(amount);
        withdrawModel.setBalance(loggedInCard.getBalance());
        withdrawModel.setDatetime(getCurrentTime());
        WithdrawRepository.save(withdrawModel);
    }

    private boolean isBalanceEnough(int withdrawAmount) {
        return loggedInCard.getBalance() >= withdrawAmount;
    }
}
