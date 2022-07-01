package org.example.screen.transfer;

import org.example.screen.contract.ScreenContract;

import static java.lang.Integer.parseInt;
import static org.example.Main.*;
import static org.example.components.MessageComponent.printErrorMessage;
import static org.example.components.MessageComponent.printTransferInputAmountMessage;
import static org.example.router.Router.gotoTransferInputReferenceString;
import static org.example.util.NumberUtil.*;
import static org.example.util.SystemUtil.println;

public class TransferInputAmountScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printTransferInputAmountMessage();
            println("Please enter amount and press enter to continue or");
            println("Press enter to go back");

            var amountString = scanner.nextLine();

            if (amountString.isEmpty()) {
                return;
            }

            if (!isAStringNumber(amountString)) {
                printErrorMessage("Invalid Amount");
                continue;
            }

            var amount = parseInt(amountString);

            if (isNegative(amount)) {
                printErrorMessage("Minimum amount to transfer is $1");
                continue;
            }

            if (isGreaterThan1000(amount)) {
                printErrorMessage("Maximum amount to transfer is $1000");
                continue;
            }

            if (!isEnoughBalance(amount)) {
                printErrorMessage("Insufficient Balance $" + amount + " in your account. " +
                        "Your balance is $" + loggedInCard.getBalance());
                continue;
            }

            transferModel.setAmount(amount);
            gotoTransferInputReferenceString();
            return;
        }
    }

    private boolean isEnoughBalance(Integer amount) {
        return loggedInCard.getBalance() >= amount;
    }
}
