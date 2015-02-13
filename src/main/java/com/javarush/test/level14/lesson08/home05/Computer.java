package com.javarush.test.level14.lesson08.home05;

/**
* Created by MakarytskyiO on 02.02.2015.
*/
class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer() {
        keyboard = new Keyboard();
        mouse = new Mouse();
        monitor = new Monitor();
    }



    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
