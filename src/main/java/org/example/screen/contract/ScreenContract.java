package org.example.screen.contract;

public abstract class ScreenContract {
    public static ScreenContract currentScreen;
    public static ScreenContract welcome, transaction, checkBalance, withdraw, otherWithdraw, summaryWithdraw, transferInputAccount, transferInputAmount, transferInputReference, transferConfirmation, transferSummary, transactionHistory;

    public void show() {}
}
