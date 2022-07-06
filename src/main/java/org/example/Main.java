package org.example;

import org.example.repository.AccountRepository;
import org.example.repository.BalanceRepository;
import org.example.repository.TransferRepository;
import org.example.repository.WithdrawRepository;

import static org.example.router.Router.gotoWelcomeScreen;

public class Main {
    public static void main(String[] args) {
        configureCSVData();
        gotoWelcomeScreen();
    }

    public static void configureCSVData() {
        AccountRepository.validateAccounts();
        AccountRepository.resetContents();
        BalanceRepository.clearContents();
        TransferRepository.clearContents();
        WithdrawRepository.clearContents();
    }
}
