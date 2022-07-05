package org.example.data;

import org.example.model.AccountModel;
import org.example.model.TransferModel;
import org.example.model.WithdrawModel;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppData {
    public static Scanner scanner = new Scanner(System.in);
    public static AccountModel loggedInCard = null;
    public static WithdrawModel withdrawModel = new WithdrawModel();
    public static TransferModel transferModel = new TransferModel();
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
}
