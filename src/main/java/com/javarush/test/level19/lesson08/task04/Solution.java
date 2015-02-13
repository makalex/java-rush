package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.OutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldSystemOut = System.out;
        PrintStream newSystemOut = new ArithmeticOperStream(System.out);
        System.setOut(newSystemOut);
        testString.printSomething();
        System.setOut(oldSystemOut);
    }

    static class ArithmeticOperStream extends PrintStream {
        public ArithmeticOperStream(OutputStream out) {
            super(out);
        }

        @Override
        public void println(String x) {
            String[] arr = x.split(" ");
            String res = null;
            String operation = arr[1];
            if ("+".equals(operation)) {
                res = String.valueOf( Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) );
            } else if ("-".equals(operation)) {
                res = String.valueOf( Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) );
            } else if ("*".equals(operation)) {
                res = String.valueOf( Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]) );
            }
            super.println(x + res);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

