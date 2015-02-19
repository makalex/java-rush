package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        FileInputStream fin = new FileInputStream(fileName);
        byte maxByte = Byte.MIN_VALUE;
        byte currentByte;
        while (fin.available() > 0) {
            currentByte = (byte)fin.read();
            if (currentByte > maxByte) {
                maxByte = currentByte;
            }
        }
        fin.close();
        System.out.println(maxByte);
    }
}
