package com.javarush.test.level14.lesson06.home01;

/**
 * Created by MakarytskyiO on 02.02.2015.
 */
class BelarusianHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 9;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
