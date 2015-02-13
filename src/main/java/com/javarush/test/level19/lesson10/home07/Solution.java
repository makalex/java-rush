package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fReader = new BufferedReader(new FileReader(fileName1));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = fReader.readLine()) != null) {
            String[] splitted = line.split(" ");
            for (String s : splitted) {
                if (s.length() > 6) {
                    sb.append(s).append(",");
                }
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        fReader.close();

        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName2));
        fWriter.write(sb.toString());
        fWriter.close();
    }
}
