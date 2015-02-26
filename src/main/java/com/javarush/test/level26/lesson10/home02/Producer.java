package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by MakarytskyiO on 26.02.2015.
 */
public class Producer implements Runnable {

    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (true) {
                System.out.println("Some text for " + i++);
                Thread.sleep(500);
            }
        }
        catch (InterruptedException e) {
            System.out.println(
                    "[" + Thread.currentThread().getName() + "] thread was terminated");
        }
    }
}
