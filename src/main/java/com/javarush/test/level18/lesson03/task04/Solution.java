package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байты, которые встречаются в файле меньше всего раз.
Вывести их на экран через пробел
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

        int min = Integer.MAX_VALUE;
        Collection<Integer> values = bytesFrequency.values();
        for (Integer value : values) {
            if (value < min) {
                min = value;
            }
        }

        for (Map.Entry<Byte, Integer> pair : bytesFrequency.entrySet()) {
            if (pair.getValue() == min) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
