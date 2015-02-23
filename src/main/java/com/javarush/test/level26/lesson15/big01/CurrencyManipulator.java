package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MakarytskyiO on 23.02.2015.
 */
public class CurrencyManipulator {

    private String currencyCode;

    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int res = 0;
        for (Map.Entry<Integer, Integer> i : denominations.entrySet()) {
            res += i.getKey() * i.getValue();
        }
        return res;
    }
}
