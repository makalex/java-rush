package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть поток ввода.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        String line;
        int count = 0;
        while ((line = fReader.readLine()) != null) {
            line = line.toLowerCase();
            line = line.replaceAll("[\\p{P}]", " ");
            String[] arr = line.split(" ");
            for (String s : arr) {
                if (s.equals("world")) {
                    count++;
                }
            }
        }
        fReader.close();
        System.out.println(count);
    }
}
