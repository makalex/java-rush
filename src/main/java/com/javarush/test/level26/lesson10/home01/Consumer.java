package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by MakarytskyiO on 26.02.2015.
 */
public class Consumer implements Runnable {

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(queue.poll(500, TimeUnit.MILLISECONDS));
            }
        }
        catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
