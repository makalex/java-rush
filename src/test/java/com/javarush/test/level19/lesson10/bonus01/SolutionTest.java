package com.javarush.test.level19.lesson10.bonus01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

public class SolutionTest {
    static InputStream oldSystemIn = System.in;
    static PrintStream oldSystemOut = System.out;

    @Test
    public void mainTest1() throws Exception {
        String oldFileName = "resources/level19/lesson10/bonus01/t1_old.txt";
        String newFileName = "resources/level19/lesson10/bonus01/t1_new.txt";


        // set new System.in and System.out streams
        byte[] streamContent = (oldFileName + "\n" + newFileName).getBytes();
        System.setIn(new ByteArrayInputStream(streamContent));
        ByteArrayOutputStream newSystemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newSystemOut));

        Solution solution = new Solution();
        solution.main(null);

        // restore old System.in and System.out streams
        System.setIn(oldSystemIn);
        System.setOut(oldSystemOut);


        // expected result
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("SAME 1");
        expectedList.add("REMOVED 2");
        expectedList.add("SAME 3");
        expectedList.add("ADDED 4");

        // actual result
        List<String> actualList = new ArrayList<String>();
        for (Solution.LineItem lineItem : Solution.lines) {
            actualList.add(lineItem.type + " " + lineItem.line);
        }


        Assert.assertEquals(expectedList, actualList);
    }
}
