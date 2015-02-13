package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = console.readLine();
        String fileName2 = console.readLine();

        BufferedReader fReader = new BufferedReader(new FileReader(fileName1));
        List<String> numbersList = new LinkedList<String>();
        String line;
        while ((line = fReader.readLine()) != null) {
            String[] arr = line.split(" ");
            for (String s : arr) {
                try {
                    Integer.parseInt(s);
                    numbersList.add(s);
                } catch (NumberFormatException ignore) {}
            }
        }
        fReader.close();

        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName2));
        for (String s : numbersList) {
            fWriter.write(s + " ");
        }
        fWriter.close();
    }
}
