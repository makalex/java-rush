package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        int charCount = 0;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[fileInputStream.available()];
        if (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);
        }
        fileInputStream.close();

        for (byte b : buffer) {
            if ((b > 64 && b < 91) || (b > 96 && b < 123))
                charCount++;
        }

        System.out.print(charCount);
    }
}
