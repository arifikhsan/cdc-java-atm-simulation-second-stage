package org.example.util;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import static org.example.components.MessageComponent.printGoodByeMessage;

public class SystemUtil {
    public static void println(String string) {
        System.out.println(string);
    }

    public static void print(String string) {
        System.out.print(string);
    }

    public static void println() {
        System.out.println();
    }

    public static void printlnRedText(String string) {
        println(colorize(string, RED_TEXT()));
    }

    public static void printlnGreenText(String string) {
        println(colorize(string, GREEN_TEXT()));
    }

    public static void printlnBlueText(String string) {
        println(colorize(string, BLUE_TEXT()));
    }

    public static void printEmptyLine() {
        println();
    }

    public static void printDoubleEmptyLine() {
        println();
        println();
    }

    public static void exitApp() {
        printGoodByeMessage();
        exitConsoleApp();
    }

    public static void exitConsoleApp() {
        System.exit(0);
    }
}
