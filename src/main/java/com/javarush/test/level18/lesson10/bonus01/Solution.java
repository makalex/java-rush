package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        String key = args[0];
        String inFileName = args[1];
        String outFileName = args[2];

        FileInputStream fin = new FileInputStream(inFileName);
        byte[] inFileBytes = new byte[fin.available()];
        fin.read(inFileBytes);
        fin.close();

        if ("-e".equals(key)) {
            for (int i = 0; i < inFileBytes.length; i++) {
                inFileBytes[i] = (byte) (inFileBytes[i] + 1);
            }
        } else if ("-d".equals(key)) {
            for (int i = 0; i < inFileBytes.length; i++) {
                inFileBytes[i] = (byte) (inFileBytes[i] - 1);
            }
        }

        FileOutputStream fout = new FileOutputStream(outFileName);
        fout.write(inFileBytes);
        fout.close();
    }
}
