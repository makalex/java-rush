package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();

        Map<Byte, Integer> map = new TreeMap<>();
        for (byte b : buffer) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }

        for (Map.Entry<Byte, Integer> pair : map.entrySet()) {
            System.out.println((char)pair.getKey().byteValue() + " " + pair.getValue());
        }
    }
}
