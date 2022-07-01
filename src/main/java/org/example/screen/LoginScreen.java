package org.example.screen;

import org.example.screen.contract.ScreenContract;

import static org.example.Main.*;
import static org.example.components.MessageComponent.*;
import static org.example.router.Router.gotoTransactionScreen;
import static org.example.util.NumberUtil.isAStringNumber;
import static org.example.util.StringUtil.isExact6Digits;
import static org.example.util.SystemUtil.print;
import static org.example.util.SystemUtil.println;

public class LoginScreen implements ScreenContract {
    @Override
    public void show() {
        String cardNumber;
        String pin;

        while (true) {
            printLoginMessage();

            print("Enter your card number: ");
            cardNumber = scanner.nextLine();

            println();

            if (cardNumber.isEmpty()) {
                printErrorMessage("Please enter your card number");
                continue;
            }

            if (!isAStringNumber(cardNumber)) {
                printErrorMessage("Account Number should only contains numbers");
                continue;
            }

            if (!isExact6Digits(cardNumber)) {
                printErrorMessage("Account Number should have 6 digits length");
                continue;
            }

            println("Your card number is " + cardNumber);

            print("Enter your PIN: ");
            pin = scanner.nextLine();

            if (pin.isEmpty()) {
                printErrorMessage("Please enter your PIN");
                continue;
            }

            if (!isAStringNumber(pin)) {
                printErrorMessage("PIN should only contains numbers");
                continue;
            }

            if (!isExact6Digits(pin)) {
                printErrorMessage("PIN should have 6 digits length");
                continue;
            }

            println("Your PIN is " + pin);

            if (!cardRepository.isExistByCardNumberAndPin(cardNumber, pin)) {
                printErrorMessage("Wrong card number or PIN");
                continue;
            }

            loggedInCard = cardRepository.getCardByNumber(cardNumber);
            printSuccessMessage("Welcome, " + loggedInCard.getName());
            gotoTransactionScreen();
            return;
        }
    }
}
