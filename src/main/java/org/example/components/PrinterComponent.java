package org.example.components;

import org.example.model.BalanceInquiryModel;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;

import static org.example.data.AppData.dateTimeFormatter;
import static org.example.util.SystemUtil.printEmptyLine;
import static org.example.util.SystemUtil.printlnBlueText;

public class PrinterComponent {
    public static void printBalance(BalanceInquiryModel balanceModel) {
        printlnBlueText("=========== Balance Inquiry ==========");
        printlnBlueText("By: " + balanceModel.getActor().getName());
        printlnBlueText("Balance: $" + balanceModel.getBalance());
        printlnBlueText("Account Name: " + balanceModel.getCard().getName());
        printlnBlueText("Account Number: " + balanceModel.getCard().getNumber());
        printlnBlueText("Happened At: " + balanceModel.getHappenedAt().format(dateTimeFormatter));
        printlnBlueText("======================================");
        printEmptyLine();
    }

    public static void printWithdraw(WithdrawModel withdrawModel) {
        printlnBlueText("============== Withdraw ==============");
        printlnBlueText("Amount: $" + withdrawModel.getAmount());
        printlnBlueText("By: " + withdrawModel.getActor().getName());
        printlnBlueText("Account Name: " + withdrawModel.getCard().getName());
        printlnBlueText("Account Number: " + withdrawModel.getCard().getNumber());
        printlnBlueText("Happened At: " + withdrawModel.getHappenedAt().format(dateTimeFormatter));
        printlnBlueText("======================================");
        printEmptyLine();
    }

    public static void printTransfer(TransferModel transferModel) {
        printlnBlueText("============== Transfer ==============");
        printlnBlueText("Amount: $" + transferModel.getAmount());
        printlnBlueText("By: " + transferModel.getActor().getName());
        printlnBlueText("=== From ===");
        printlnBlueText("Name: " + transferModel.getFromAccount().getName());
        printlnBlueText("Number: " + transferModel.getFromAccount().getNumber());
        printlnBlueText("============");
        printlnBlueText("=== To ===");
        printlnBlueText("Name: " + transferModel.getToAccount().getName());
        printlnBlueText("Number: " + transferModel.getToAccount().getNumber());
        printlnBlueText("============");
        printlnBlueText("Happened At: " + transferModel.getHappenedAt().format(dateTimeFormatter));
        printlnBlueText("======================================");
        printEmptyLine();
    }
}
