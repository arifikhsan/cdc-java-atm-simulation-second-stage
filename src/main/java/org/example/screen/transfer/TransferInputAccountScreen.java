package org.example.screen.transfer;

import org.example.repository.AccountRepository;
import org.example.screen.contract.ScreenContract;

import static org.example.components.MessageComponent.printErrorMessage;
import static org.example.components.MessageComponent.printTransferInputAccountMessage;
import static org.example.data.AppData.*;
import static org.example.util.StringUtil.isValidAccountNumber;
import static org.example.util.SystemUtil.println;

public class TransferInputAccountScreen extends ScreenContract {
    @Override
    public void show() {
        while (true) {
            printTransferInputAccountMessage();
            println("Please enter destination account and press enter to continue or");
            println("Press enter to go back to main menu");

            var destinationAccountNumber = scanner.nextLine();

            if (destinationAccountNumber.isEmpty()) {
                currentScreen = transaction;
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

            var destinationAccount = AccountRepository.getAccountByNumber(destinationAccountNumber);
            transferModel.setFromAccount(loggedInCard);
            transferModel.setToAccount(destinationAccount);
            currentScreen = transferInputAmount;
            return;
        }
    }

    private boolean isMyOwnAccount(String destinationAccountNumber) {
        return loggedInCard.getNumber().equals(destinationAccountNumber);
    }

    private boolean isAccountExist(String destinationAccount) {
        return AccountRepository.isExistByCardNumber(destinationAccount);
    }
}
