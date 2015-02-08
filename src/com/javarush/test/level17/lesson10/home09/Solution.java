package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Сигнатуру метода main не менять.  Метод joinData должен вызываться в main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            String line;
            while ((line = fileReader.readLine()) != null) {
                allLines.add(line);
            }
            fileReader.close();

            fileReader = new BufferedReader(new FileReader(fileName2));
            while ((line = fileReader.readLine()) != null) {
                forRemoveLines.add(line);
            }


            List<String> saved = new ArrayList<String>(allLines);
            try {
                new Solution().joinData();
            }
            catch (CorruptedDataException e) {
                allLines = saved;
            }
        }
        catch (IOException e) {

        }
    }

    public void joinData () throws CorruptedDataException {
        boolean containsAll = true;
        for (String s : forRemoveLines) {
            if (!allLines.contains(s)) {
                containsAll = false;
                break;
            }
        }
        if (containsAll) {
            for (String s : forRemoveLines) {
                allLines.remove(s);
            }
        } else  {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
