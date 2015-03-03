package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

public class Restaurant {
    public static void main(String[] args) {
        Waitor waitor = new Waitor();
        Cook cook = new Cook("Amigo");
        cook.addObserver(waitor);

        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();
    }
}
