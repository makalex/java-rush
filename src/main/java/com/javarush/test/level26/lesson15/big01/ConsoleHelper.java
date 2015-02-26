package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MakarytskyiO on 23.02.2015.
 */
public class ConsoleHelper {

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() throws InterruptOperationException{
        String line = null;
        try {
            line = console.readLine();
            if (line.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        }
        catch (IOException e) {}

        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException{
        System.out.println("Enter currency code...");
        String currCode;
        while ((currCode = readString()).length() != 3) {
            System.out.println("Error. Try again...");
        }
        return currCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        System.out.println("Enter nominal and amount...");
        String[] res;
        while (true) {
            try {
                String[] splitted = readString().split(" ");
                int nominal = Integer.parseInt(splitted[0]);
                int amount = Integer.parseInt(splitted[1]);
                res = new String[] {String.valueOf(nominal), String.valueOf(amount)};
                break;
            }
            catch (RuntimeException e) {
                System.out.println("Error. Try again...");
            }
        }
        return res;
    }

    public static Operation askOperation() throws InterruptOperationException{
        System.out.println("Enter operation...(1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT)");
        Operation operation = null;
        while (true) {
            try {
                int operationNumber = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(operationNumber);
                break;
            }
            catch (NumberFormatException e ) {
                System.out.println("Error. Try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("Error. Try again...");
            }
        }
        return operation;
    }
}
