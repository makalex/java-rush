package com.javarush.test.level26.lesson15.big01;

import java.util.*;

/**
 * Created by MakarytskyiO on 23.02.2015.
 */
public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> currencyManipulators = new HashMap<>();

    // private
    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (currencyManipulators.containsKey(currencyCode)) {
            return currencyManipulators.get(currencyCode);
        } else {
            CurrencyManipulator newCurrencyManipulator = new CurrencyManipulator(currencyCode);
            currencyManipulators.put(currencyCode, newCurrencyManipulator);
            return newCurrencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return currencyManipulators.values();
    }

}
