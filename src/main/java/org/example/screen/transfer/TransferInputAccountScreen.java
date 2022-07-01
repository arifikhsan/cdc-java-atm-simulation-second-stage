package org.example.screen.transfer;

import org.example.screen.contract.ScreenContract;

import static org.example.Main.*;
import static org.example.components.MessageComponent.printErrorMessage;
import static org.example.components.MessageComponent.printTransferInputAccountMessage;
import static org.example.router.Router.gotoTransferInputAmountScreen;
import static org.example.util.StringUtil.isValidAccountNumber;
import static org.example.util.SystemUtil.println;

public class TransferInputAccountScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            printTransferInputAccountMessage();
            println("Please enter destination account and press enter to continue or");
            println("Press enter to go back to main menu");

            var destinationAccountNumber = scanner.nextLine();

            if (destinationAccountNumber.isEmpty()) {
                return;
            }

            if (!isValidAccountNumber(destinationAccountNumber)) {
                printErrorMessage("Invalid Account");
                continue;
            }

            if (!isAccountExist(destinationAccountNumber)) {
                printErrorMessage("Account does not exist");
                continue;
            }

            if (isMyOwnAccount(destinationAccountNumber)) {
                printErrorMessage("You can't transfer to your own account");
                continue;
            }

            var destinationAccount = cardRepository.getAccountByNumber(destinationAccountNumber);
            transferModel.setFromAccount(loggedInCard);
            transferModel.setToAccount(destinationAccount);
            gotoTransferInputAmountScreen();
            return;
        }
    }

    private boolean isMyOwnAccount(String destinationAccountNumber) {
        return loggedInCard.getNumber().equals(destinationAccountNumber);
    }

    private boolean isAccountExist(String destinationAccount) {
        return cardRepository.isExistByCardNumber(destinationAccount);
    }
}
