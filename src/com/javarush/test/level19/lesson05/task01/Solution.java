package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = console.readLine();
        String fileName2 = console.readLine();

        FileInputStream fin = new FileInputStream(fileName1);
        byte[] buf = new byte[fin.available()];
        fin.read(buf);
        fin.close();

        FileOutputStream fout = new FileOutputStream(fileName2);
        for (int i = 0; i < buf.length; i++) {
            if (i % 2 == 1) {
                fout.write(buf[i]);
            }
        }
        fout.close();
    }
}
