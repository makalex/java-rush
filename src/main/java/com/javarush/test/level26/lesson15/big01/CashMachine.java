package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;

import java.util.Locale;

/**
 * Created by MakarytskyiO on 23.02.2015.
 */
public class CashMachine {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ENGLISH);

        Operation operation;
        do {
            int operationOrdinal = Integer.parseInt(ConsoleHelper.readString());
            operation = Operation.getAllowableOperationByOrdinal(operationOrdinal);
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);


        // Считаем с консоли код валюты, потом считаем номинал и количество банкнот, а потом добавим их в манипулятор.
//
//
//        currencyManipulator.addAmount(Integer.parseInt(den[0]), Integer.parseInt(den[1]));
//        currencyManipulator.getTotalAmount();

    }
}
