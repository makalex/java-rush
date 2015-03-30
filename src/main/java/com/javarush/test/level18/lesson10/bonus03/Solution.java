package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //args = new String[] {"-u", "4", "asdaskjфыд1флдыдфлыо", "121", "12"};
        //args = new String[] {"-d", "7"};

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();

        if ("-u".equals(args[0])) {
            String id = padRight(args[1], 8);
            String newProductName = padRight(args[2], 30);
            String newPrice = padRight(args[3], 8);
            String newQuantity = padRight(args[4], 4);

            List<StringBuilder> fileLines = readFileLines(fileName);
            for (StringBuilder line : fileLines) {
                if (id.equals(line.substring(0, 8))) {
                    line.setLength(0); // clear string
                    line.append(id + newProductName + newPrice + newQuantity);
                    break;
                }
            }
            writeFile(fileName, fileLines);

        }
        else if ("-d".equals(args[0])) {
            String id = padRight(args[1], 8);

            List<StringBuilder> fileLines = readFileLines(fileName);
            Iterator<StringBuilder> iter = fileLines.iterator();
            while (iter.hasNext()) {
                if (id.equals(iter.next().substring(0, 8))) {
                    iter.remove();
                    break;
                }
            }
            writeFile(fileName, fileLines);
        }
    }

    private static List<StringBuilder> readFileLines(String fileName) throws IOException {
        List<StringBuilder> fileLines = new LinkedList<>();
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        String str;
        while ((str = fReader.readLine()) != null) {
            fileLines.add(new StringBuilder(str));
        }
        fReader.close();
        return fileLines;
    }

    private static void writeFile(String fileName, List<StringBuilder> fileLines) throws IOException {
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName));
        for (StringBuilder line : fileLines) {
            fWriter.write(line.toString());
            fWriter.newLine();
        }
        fWriter.close();
    }

    private static String padRight(String input, int len) {
        if (input.length() < len) {
            return String.format("%1$-" + len + "s", input);
        } else {
            return input.substring(0, len);
        }
    }
}
