package com.javarush.test.level15.lesson12.home04;

/**
 * Created by MakarytskyiO on 03.02.2015.
 */
class Sun implements Planet {

    private static Sun instance;

    private Sun() {}

    public static Sun getInstance() {
        if (instance == null)
            instance = new Sun();
        return instance;
    }
}
