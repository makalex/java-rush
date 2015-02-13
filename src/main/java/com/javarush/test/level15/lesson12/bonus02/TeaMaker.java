package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by MakarytskyiO on 03.02.2015.
 */
class TeaMaker extends DrinkMaker {
    @Override
    void getRightCup() {
        System.out.println("Берем чашку для чая");
    }

    @Override
    void putIngredient() {
        System.out.println("Насыпаем чай");
    }

    @Override
    void pour() {
        System.out.println("Заливаем водой");
    }
}
