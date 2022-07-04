package org.example.router;

import org.example.screen.BalanceScreen;
import org.example.screen.LoginScreen;
import org.example.screen.TransactionScreen;
import org.example.screen.WelcomeScreen;
import org.example.screen.history.TransactionHistoryScreen;
import org.example.screen.transfer.*;
import org.example.screen.withdraw.WithdrawCustomScreen;
import org.example.screen.withdraw.WithdrawScreen;
import org.example.screen.withdraw.WithdrawSummaryScreen;

public class Router {
    public static void gotoWelcomeScreen() {
        new WelcomeScreen().show();
    }

    public static void gotoTransactionScreen() {
        new TransactionScreen().show();
    }

    public static void gotoLoginScreen() {
        new LoginScreen().show();
    }

    public static void gotoWithdrawScreen() {
        new WithdrawScreen().show();
    }

    public static void gotoTransferScreen() {
        new TransferInputAccountScreen().show();
    }

    public static void gotoTransactionHistoryScreen() {
        new TransactionHistoryScreen().show();
    }

    public static void gotoBalanceScreen() {
        new BalanceScreen().show();
    }

    public static void gotoWithdrawCustomScreen() {
        new WithdrawCustomScreen().show();
    }

    public static void gotoWithdrawSummaryScreen() {
        new WithdrawSummaryScreen().show();
    }

    public static void gotoSummaryScreen() {
        new TransferSummaryScreen().show();
    }

    public static void gotoTransferInputAmountScreen() {
        new TransferInputAmountScreen().show();
    }

    public static void gotoTransferInputReferenceString() {
        new TransferInputReferenceScreen().show();
    }

    public static void gotoTransferConfirmationScreen() {
        new TransferConfirmationScreen().show();
    }
}
