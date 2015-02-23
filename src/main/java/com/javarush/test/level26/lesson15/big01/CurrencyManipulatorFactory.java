package com.javarush.test.level26.lesson15.big01;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by MakarytskyiO on 23.02.2015.
 */
public class CurrencyManipulatorFactory {

    private static Set<CurrencyManipulator> currencyManipulators = new HashSet<>();

    // private
    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        for (CurrencyManipulator cm : currencyManipulators) {
            if (cm.getCurrencyCode().equals(currencyCode)) {
                return cm;
            }
        }

        CurrencyManipulator res = new CurrencyManipulator(currencyCode);
        currencyManipulators.add(res);
        return res;
    }
}
