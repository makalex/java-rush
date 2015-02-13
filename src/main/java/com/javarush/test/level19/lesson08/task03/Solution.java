package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Пример вывода:
12345678
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldSystemOut = System.out;
        ByteArrayOutputStream newSystemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newSystemOut));
        testString.printSomething();
        String x = newSystemOut.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x.length(); i++) {
            if (Character.isDigit(x.charAt(i))) {
                sb.append(x.charAt(i));
            }
        }
        System.setOut(oldSystemOut);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
