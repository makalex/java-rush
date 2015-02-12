package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/


import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        PrintStream oldOutStream = System.out;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        PrintStream newOutStream = new PrintStream(byteStream);
        System.setOut(newOutStream);
        testString.printSomething();
        System.setOut(oldOutStream);

        ByteArrayInputStream in = new ByteArrayInputStream(byteStream.toByteArray());
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int i = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (i % 2 == 1) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            i++;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
