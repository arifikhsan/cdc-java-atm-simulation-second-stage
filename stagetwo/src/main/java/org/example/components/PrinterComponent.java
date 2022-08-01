package org.example.components;

import org.example.model.BalanceInquiryModel;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;

import static org.example.data.AppData.dateTimeFormatter;
import static org.example.util.SystemUtil.printEmptyLine;
import static org.example.util.SystemUtil.printlnBlueText;

public class PrinterComponent {
    public static void printBalance(Integer number, BalanceInquiryModel balanceModel) {
        printlnBlueText("=[" + number + "]======= Balance Inquiry ==========");
        printlnBlueText("By: " + balanceModel.getActor().getName());
        printlnBlueText("Balance: $" + balanceModel.getBalance());
        printlnBlueText("Account Name: " + balanceModel.getAccount().getName());
        printlnBlueText("Account Number: " + balanceModel.getAccount().getNumber());
        printlnBlueText("Happened At: " + balanceModel.getHappenedAt().format(dateTimeFormatter));
        printlnBlueText("======================================");
        printEmptyLine();
    }

    public static void printWithdraw(Integer number, WithdrawModel withdrawModel) {
        printlnBlueText("=[" + number + "]=========== Withdraw ==============");
        printlnBlueText("Amount: $" + withdrawModel.getAmount());
        printlnBlueText("By: " + withdrawModel.getActor().getName());
        printlnBlueText("Account Name: " + withdrawModel.getAccount().getName());
        printlnBlueText("Account Number: " + withdrawModel.getAccount().getNumber());
        printlnBlueText("Happened At: " + withdrawModel.getHappenedAt().format(dateTimeFormatter));
        printlnBlueText("======================================");
        printEmptyLine();
    }

    public static void printTransfer(Integer number, TransferModel transferModel) {
        printlnBlueText("=[" + number + "]=========== Transfer ==============");
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
