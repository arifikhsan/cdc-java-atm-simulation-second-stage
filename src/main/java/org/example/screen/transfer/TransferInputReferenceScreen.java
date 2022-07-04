package org.example.screen.transfer;

import org.example.screen.contract.ScreenContract;

import static org.example.components.MessageComponent.printErrorMessage;
import static org.example.components.MessageComponent.printTransferInputReferenceMessage;
import static org.example.data.AppData.scanner;
import static org.example.data.AppData.transferModel;
import static org.example.router.Router.gotoTransferConfirmationScreen;
import static org.example.util.NumberUtil.generateRandomSixDigitNumber;
import static org.example.util.NumberUtil.isAStringNumber;
import static org.example.util.SystemUtil.println;
import static org.example.util.TimeUtil.getCurrentTime;

public class TransferInputReferenceScreen implements ScreenContract {
    @Override
    public void show() {
        while (true) {
            var referenceNumber = generateRandomSixDigitNumber();

            printTransferInputReferenceMessage();
            println("Reference Number (This is an autogenerated random 6 digits number)");
            println(referenceNumber.toString());
            println("Press enter to continue");

            scanner.nextLine();

            if (referenceNumber.toString().isEmpty()) {
                printErrorMessage("Invalid Reference Number");
                continue;
            }

            if (!isAStringNumber(referenceNumber.toString())) {
                printErrorMessage("Invalid Reference Number");
                continue;
            }

            transferModel.setReference(referenceNumber);
            transferModel.setDateTime(getCurrentTime());
            gotoTransferConfirmationScreen();
            return;
        }
    }
}
