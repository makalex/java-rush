package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
[Файл 1]
строка1
строка2
строка3

[Файл 2]
строка1
строка3
строка4

[Результат - список lines]
SAME строка1
REMOVED строка2
SAME строка3
ADDED строка4
*/
public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String oldFileName = console.readLine();
        String newFileName = console.readLine();

        List<String> oldFileLines = readFileLines(oldFileName);
        List<String> newFileLines = readFileLines(newFileName);

        // algorithm work only if data into the files are correct (according to the task)
        boolean iterateByOldFile = true;

        while (oldFileLines.size() > 0 && newFileLines.size() > 0) {

            // iterate by lines in old file
            if (iterateByOldFile)
            {
                if ( oldFileLines.get(0).equals(newFileLines.get(0)) ) {
                    lines.add(new LineItem(Type.SAME, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                    newFileLines.remove(0);
                } else
                if ( oldFileLines.get(0).equals(newFileLines.get(1)) ) {
                    lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
                    newFileLines.remove(0);
                    iterateByOldFile = !iterateByOldFile;
                } else {
                    lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                }
            }
            // iterate by lines in new file
            else
            {
                if ( newFileLines.get(0).equals(oldFileLines.get(0)) ) {
                    lines.add(new LineItem(Type.SAME, newFileLines.get(0)));
                    newFileLines.remove(0);
                    oldFileLines.remove(0);
                } else
                if ( newFileLines.get(0).equals(oldFileLines.get(1)) ) {
                    lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
                    oldFileLines.remove(0);
                    iterateByOldFile = !iterateByOldFile;
                } else {
                    lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
                    newFileLines.remove(0);
                }
            }
        }

        if (oldFileLines.size() > 0) {
            lines.add(new LineItem(Type.REMOVED, oldFileLines.get(0)));
        } else if (newFileLines.size() > 0) {
            lines.add(new LineItem(Type.ADDED, newFileLines.get(0)));
        }
        // file may contain another records, but we don't take it into account

        for (LineItem i : lines) {
            System.out.println(i.type + " " + i.line);
        }
    }

    static List<String> readFileLines(String fileName) throws IOException {
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        List<String> fileLines = new ArrayList<String>();
        String line;
        while ((line = fReader.readLine()) != null) {
            fileLines.add(line);
        }
        fReader.close();
        return fileLines;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
