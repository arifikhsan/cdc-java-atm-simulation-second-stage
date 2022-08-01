package org.example;

import org.example.repository.AccountRepository;
import org.example.repository.BalanceRepository;
import org.example.repository.TransferRepository;
import org.example.repository.WithdrawRepository;
import org.example.screen.BalanceScreen;
import org.example.screen.LoginScreen;
import org.example.screen.TransactionScreen;
import org.example.screen.contract.ScreenContract;
import org.example.screen.history.TransactionHistoryScreen;
import org.example.screen.transfer.*;
import org.example.screen.withdraw.WithdrawCustomScreen;
import org.example.screen.withdraw.WithdrawScreen;
import org.example.screen.withdraw.WithdrawSummaryScreen;

@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    public static void main(String[] args) {
        configureCSVData();
        initializeScreen();

        while (true) {
            ScreenContract.currentScreen.show();
        }
    }

    public static void configureCSVData() {
        AccountRepository.validateAccounts();
        AccountRepository.resetContents();
        BalanceRepository.clearContents();
        TransferRepository.clearContents();
        WithdrawRepository.clearContents();
    }

    public static void initializeScreen() {
        ScreenContract.welcome = new LoginScreen();
        ScreenContract.transaction = new TransactionScreen();
        ScreenContract.transactionHistory = new TransactionHistoryScreen();
        ScreenContract.checkBalance = new BalanceScreen();
        ScreenContract.withdraw = new WithdrawScreen();
        ScreenContract.otherWithdraw = new WithdrawCustomScreen();
        ScreenContract.summaryWithdraw = new WithdrawSummaryScreen();
        ScreenContract.transferInputAccount = new TransferInputAccountScreen();
        ScreenContract.transferInputAmount = new TransferInputAmountScreen();
        ScreenContract.transferInputReference = new TransferInputReferenceScreen();
        ScreenContract.transferConfirmation = new TransferConfirmationScreen();
        ScreenContract.transferSummary = new TransferSummaryScreen();
        ScreenContract.currentScreen = ScreenContract.welcome;
    }
}
