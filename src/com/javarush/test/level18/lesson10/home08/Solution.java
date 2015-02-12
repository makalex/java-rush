package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Не забудьте закрыть все потоки
*/

public class Solution {
    private static Object lock = new Object();
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName;
            while ( ! "exit".equals(fileName = console.readLine()) ) {
                new ReadThread(fileName).start();
            }
        }
        catch (Exception ignore) {}
    }


    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileInputStream fin = new FileInputStream(fileName);
                List<Integer> byteList = new ArrayList<Integer>();
                while (fin.available() > 0) {
                    byteList.add(fin.read());
                }
                fin.close();

                int currentByte;
                Map<Integer, Integer> byteOccurr = new HashMap<Integer, Integer>();
                for (int i = 0; i < byteList.size(); i++) {
                    currentByte = byteList.get(i);
                    if (byteOccurr.containsKey(currentByte)) {
                        byteOccurr.put(currentByte, byteOccurr.get(currentByte) + 1);
                    } else {
                        byteOccurr.put(currentByte, 1);
                    }
                }
                int maxOccurrByte = 0;
                int maxOccurrCount = 0;
                for (Map.Entry<Integer, Integer> pairs : byteOccurr.entrySet()) {
                    if (pairs.getValue() > maxOccurrCount) {
                        maxOccurrCount = pairs.getValue();
                        maxOccurrByte = pairs.getKey();
                    }
                }

                synchronized (lock) {
                    resultMap.put(fileName, maxOccurrByte);
                }
            }
            catch (IOException e) {

            }
        }
    }
}
