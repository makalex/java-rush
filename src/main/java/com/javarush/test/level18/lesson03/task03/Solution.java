package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байты, которые чаше всех встречаются в файле
Вывести их на экран через пробел.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        Map<Byte, Integer> bytesFrequency = new HashMap<>();

        while (inputStream.available() > 0) {
            byte b = (byte) inputStream.read();
            if (bytesFrequency.containsKey(b)) {
                bytesFrequency.put(b, bytesFrequency.get(b) + 1);
            } else {
                bytesFrequency.put(b, 1);
            }
        }
        inputStream.close();

        int max = 0;
        Collection<Integer> values = bytesFrequency.values();
        for (Integer value : values) {
            if (value > max) {
                max = value;
            }
        }

        for (Map.Entry<Byte, Integer> pair : bytesFrequency.entrySet()) {
            if (pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
