package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();

        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        Pattern pattern = Pattern.compile("[0-9]|10|11|12");
        String line;
        while ((line = fReader.readLine()) != null) {
            String[] splitted = line.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String s : splitted) {
                if (pattern.matcher(s).matches()) {
                    sb.append(map.get(Integer.parseInt(s))).append(" ");
                    continue;
                }
                sb.append(s).append(" ");
            }
            sb.replace(sb.length() - 1, sb.length(), "");
            System.out.println(sb.toString());
        }
        fReader.close();
    }
}
