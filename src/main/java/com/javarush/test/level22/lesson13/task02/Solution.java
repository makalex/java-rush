package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        //String inFileName = "src/test/resources/level22/lesson13/task02/t1.txt";
        //String outFileName = "src/test/resources/level22/lesson13/task02/t2.txt";

        String inFileName = args[0];
        String outFileName = args[1];
        BufferedReader fReader = new BufferedReader(new InputStreamReader(new FileInputStream(inFileName), "UTF-8"));
        List<String> lines = new ArrayList<>();
        while (fReader.ready()) {
            lines.add(fReader.readLine());
        }
        fReader.close();

        BufferedWriter fWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFileName), "Windows-1251"));
        for (int i = 0; i < lines.size(); i++) {
            fWriter.write(lines.get(i));
            if (i != lines.size() - 1) {
                fWriter.newLine();
            }
        }
        fWriter.close();
    }
}
