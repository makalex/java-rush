package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
*/

import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldSystemOut = System.out;
        PrintStream newSystemOut = new ReplacePrintStream(System.out);
        System.setOut(newSystemOut);
        testString.printSomething();
        System.setOut(oldSystemOut);
    }

    static class ReplacePrintStream extends PrintStream {
        private PrintStream out;

        public ReplacePrintStream(PrintStream out) {
            super(out);
            this.out = out;
        }

        @Override
        public void println(String x) {
            out.println(x.replace("te", "??"));
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}
