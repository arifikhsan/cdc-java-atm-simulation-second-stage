package org.example.util;

import static java.lang.Integer.parseInt;
import static org.example.util.NumberUtil.isAStringNumber;
import static org.example.util.NumberUtil.isPositive;

public class StringUtil {
    public static boolean isExact6Digits(String input) {
        return input.matches("\\d{6}");
    }

    public static boolean isValidAccountNumber(String account) {
        return !account.isEmpty() && isAStringNumber(account) && isExact6Digits(account);
    }

    public static boolean isValidAmountOfMoney(String amount) {
        return !amount.isEmpty() && isAStringNumber(amount) && isPositive(parseInt(amount));
    }
}
