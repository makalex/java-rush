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
        String result = String.valueOf(a);
        BinaryRepresentationTask task = new BinaryRepresentationTask(a);
        task.fork();
        if (b > 0)
        {
            //return task.join();
        }
        return result;
    }
}
