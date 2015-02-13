package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName2));
        Pattern pattern = Pattern.compile("\\d");
        String line;
        while ((line = fReader.readLine()) != null) {
            String[] splitted = line.split(" ");
            for (String s : splitted) {
                if (pattern.matcher(s).find()) {
                    fWriter.write(s + " ");
                }
            }
        }
        fReader.close();
        fWriter.close();
    }
}
