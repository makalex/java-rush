package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // args = new String[] {"-c", "asdaskjфыдфлдыдфлыо", "121", "12"};
        String productName = padRight(args[1], 30);
        String price = padRight(args[2], 8);
        String quantity = padRight(args[3], 4);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        String id = padRight(String.valueOf(getMaxId(fileName) + 1), 8);

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
        fileWriter.write(id + productName + price + quantity);
        fileWriter.newLine();
        fileWriter.close();
    }

    private static String padRight(String input, int length) {
        if (input.length() < length) {
            return String.format("%1$-" + length + "s", input);
        } else {
            return input.substring(0, length);
        }
    }

    private static long getMaxId(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        long maxId = 0;
        long currId;
        String line;
        while ((line = fileReader.readLine()) != null) {
            currId = Integer.parseInt(line.substring(0, 8).trim());
            if (currId > maxId) {
                maxId = currId;
            }
        }
        fileReader.close();
        return maxId;
    }
}
