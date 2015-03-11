package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;


public class BinaryRepresentationTask extends RecursiveTask {

    private int i;

    public BinaryRepresentationTask(int i) {
        this.i = i;
    }

    @Override
    protected String compute() {
        int a = i % 2;
        int b = i / 2;
        if (i > 0) {

            //result += task.join();
        }


        String result = String.valueOf(a);
        BinaryRepresentationTask task = new BinaryRepresentationTask(a);
        task.fork();

        return result;
    }
}
