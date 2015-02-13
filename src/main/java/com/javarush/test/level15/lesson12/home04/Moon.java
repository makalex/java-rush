package com.javarush.test.level15.lesson12.home04;

/**
 * Created by MakarytskyiO on 03.02.2015.
 */
class Moon implements Planet {

    private static Moon instance;

    private Moon() {}

    public static Moon getInstance() {
        if (instance == null)
            instance = new Moon();
        return instance;
    }
}
