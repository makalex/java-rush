package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by MakarytskyiO on 03.02.2015.
 */
abstract class DrinkMaker {
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
