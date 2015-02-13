package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть все потоки ввода-вывода
Темповые файлы создавать нельзя, т.к. на сервере заблокирована возможность создания каких любо файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String partName;
        FileInputStream fin;
        Map<String, byte[]> fileBytesList = new TreeMap<String, byte[]>();
        byte[] fileBytes;
        String fileOutName = null;

        while ( ! "end".equals(fileName = console.readLine()) ) {
            fin = new FileInputStream(fileName);
            fileBytes = new byte[fin.available()];
            fin.read(fileBytes);
            fin.close();
            partName = fileName.substring(fileName.lastIndexOf('.'), fileName.length());
            fileBytesList.put(partName, fileBytes);
            fileOutName = fileName.substring(0, fileName.lastIndexOf('.'));
        }

        FileOutputStream fout = new FileOutputStream(fileOutName);
        for (Map.Entry<String, byte[]> pairs : fileBytesList.entrySet()) {
            fout.write(pairs.getValue());
        }
        fout.close();
    }
}
