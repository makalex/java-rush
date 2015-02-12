package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
*/

import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        PrintStream oldSystemOut = System.out;
        PrintStream newSystemOut = new UppercasePrintStream(System.out);
        System.setOut(newSystemOut);
        testString.printSomething();
        System.setOut(oldSystemOut);
    }

    static class UppercasePrintStream extends PrintStream {
        public UppercasePrintStream(PrintStream out) {
            super(out);
        }

        @Override
        public void println(String x) {
            super.println(x.toUpperCase());
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
