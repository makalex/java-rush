package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();

        PrintStream oldSystemOut = System.out;
        ByteArrayOutputStream newByteOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newByteOut));
        testString.printSomething();
        System.setOut(oldSystemOut);

        FileOutputStream fout = new FileOutputStream(fileName);
        fout.write(newByteOut.toByteArray());
        fout.close();

        System.out.println(newByteOut.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

