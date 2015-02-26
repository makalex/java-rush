package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;

class InfoCommand implements Command {

    @Override
    public void execute() {
        Collection<CurrencyManipulator> cms = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (cms.size() == 0) {
            System.out.println("No money available.");
        }

        for (CurrencyManipulator cm : cms) {
            if (cm.hasMoney()) {
                System.out.println(cm.getCurrencyCode() + " " + cm.getTotalAmount());
            } else {
                System.out.println("No money available.");
            }
        }
    }
}
