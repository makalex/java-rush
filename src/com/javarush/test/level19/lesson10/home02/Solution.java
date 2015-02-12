package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new TreeMap<String, Double>();

        String line;
        double value;
        while ((line = fReader.readLine()) != null) {
            String[] rec = line.split(" ");
            value = Double.parseDouble(rec[1]);
            if (map.containsKey(rec[0])) {
                map.put(rec[0], map.get(rec[0]) + value);
            } else {
                map.put(rec[0], value);
            }
        }
        fReader.close();

        double maxValue = 0;
        for (Map.Entry<String, Double> pairs : map.entrySet()) {
            if (pairs.getValue() > maxValue) {
                maxValue = pairs.getValue();
            }
        }

        for (Map.Entry<String, Double> pairs : map.entrySet()) {
            if (pairs.getValue() == maxValue) {
                System.out.println(pairs.getKey());
            }
        }
    }
}
