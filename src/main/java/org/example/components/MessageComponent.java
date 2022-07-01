package org.example.components;

import static org.example.util.SystemUtil.*;

public class MessageComponent {
    public static void printWelcomeMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||     Welcome to Very Good ATM     ||");
        println("======================================");
    }

    public static void printLoginMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||       Login | Very Good ATM      ||");
        println("======================================");
    }

    public static void printTransactionMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||   Transaction | Very Good ATM    ||");
        println("======================================");
    }

    public static void printWithdrawMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||  Withdraw Money | Very Good ATM  ||");
        println("======================================");
    }

    public static void printWithdrawCustomMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||  Other Withdraw | Very Good ATM  ||");
        println("======================================");
    }

    public static void printWithdrawSummaryMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("|| Withdraw Summary | Very Good ATM ||");
        println("======================================");
    }

    public static void printTransferInputAccountMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||  Transfer Money | Very Good ATM  ||");
        println("======================================");
        println("||       Input Account Number       ||");
        println("======================================");
    }

    public static void printTransferInputAmountMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||  Transfer Money | Very Good ATM  ||");
        println("======================================");
        println("||            Input Amount          ||");
        println("======================================");
    }

    public static void printTransferInputReferenceMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||  Transfer Money | Very Good ATM  ||");
        println("======================================");
        println("||      Input Reference Number      ||");
        println("======================================");
    }

    public static void printTransferSummaryMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||          Very Good ATM           ||");
        println("======================================");
        println("||      Fund Transfer Summary       ||");
        println("======================================");
    }

    public static void printTransferConfirmationMessage() {
        printDoubleEmptyLine();
        println("======================================");
        println("||          Very Good ATM           ||");
        println("======================================");
        println("||       Transfer Confirmation      ||");
        println("======================================");
    }

    public static void printGoodByeMessage() {
        println("======================================");
        println("||            Good Bye !!!          ||");
        println("======================================");
        printDoubleEmptyLine();
    }

    public static void printErrorMessage(String message) {
        printErrorLine();
        printlnRedText(message);
        printErrorLine();
    }

    public static void printSuccessMessage(String message) {
        printSuccessLine();
        printlnGreenText(message);
        printSuccessLine();
    }

    public static void printHorizontalLine() {
        println("======================================");
    }

    public static void printSuccessLine() {
        printlnGreenText("======================================");
    }

    public static void printErrorLine() {
        printlnRedText("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public static void printInvalidOptionMessage(String input) {
        printErrorLine();
        printlnRedText("Your input: " + input);
        printlnRedText("Is an invalid option. Please try again.");
        printErrorLine();
    }

    public static void printInvalidInputMessage() {
        printErrorLine();
        printlnRedText("Your input is invalid. Please try again.");
        printErrorLine();
    }
}
