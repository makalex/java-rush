package com.javarush.test.level26.lesson15.big01;

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

    public static String readString() {
        String line = null;
        try {
            line = console.readLine();
        }
        catch (IOException e) {}

        return line;
    }

    public static String askCurrencyCode() {
        System.out.println("Enter currency code...");
        String currCode = null;
        try {
            while ((currCode = console.readLine()).length() != 3) {
                System.out.println("Error. Try again...");
            }
        }
        catch (IOException e) {}
        return currCode.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        System.out.println("Enter nominal and amount...");
        String[] res;
        while (true) {
            try {
                String[] splitted = console.readLine().split(" ");
                int nominal = Integer.parseInt(splitted[0]);
                int amount = Integer.parseInt(splitted[1]);
                res = new String[] {String.valueOf(nominal), String.valueOf(amount)};
                break;
            }
            catch (NumberFormatException e) {
                System.out.println("Error. Try again...");
            } catch (IOException e) {}
        }
        return res;
    }

    public static Operation askOperation() {
        System.out.println("Enter operation...");
        Operation operation = null;
        while (true) {
            try {
                int operationNumber = Integer.parseInt(console.readLine());
                operation = Operation.getAllowableOperationByOrdinal(operationNumber);
                break;
            }
            catch (NumberFormatException e ) {
                System.out.println("Error. Try again...");
            } catch (IllegalArgumentException e) {
                System.out.println("Error. Try again...");
            } catch (IOException e) {}
        }
        return operation;
    }
}
