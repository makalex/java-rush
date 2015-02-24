package com.javarush.test.level25.lesson09.task03;

import java.util.ArrayList;
import java.util.List;

/* Живем своим умом
В классе Solution реализуйте интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений начиная с самого вложенного.
Пример исключения: new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> exList = new ArrayList<>();
        exList.add(e);
        while (e.getCause() != null) {
            exList.add(e.getCause());
            e = e.getCause();
        }
        for (int i = exList.size() - 1; i >= 0; i--) {
            System.out.println(exList.get(i));
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
            }
        });
        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }
}
