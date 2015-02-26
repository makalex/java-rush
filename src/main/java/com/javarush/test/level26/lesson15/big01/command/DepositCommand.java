package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class DepositCommand implements Command {

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] den = ConsoleHelper.getValidTwoDigits(currencyCode);
        try {
            int nominal = Integer.parseInt(den[0]);
            int amount = Integer.parseInt(den[1]);
            cm.addAmount(nominal, amount);
        }
        catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("Error...");
        }
    }
}
