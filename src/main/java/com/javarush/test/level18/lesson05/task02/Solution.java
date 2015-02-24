package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);
        }
        fileInputStream.close();

        int commaCount = 0;
        for (byte b : buffer) {
            if (b == (byte)',') {
                commaCount++;
            }
        }

        System.out.println(commaCount);
    }
}
