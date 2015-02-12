package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            String tag = args[0];
            //String tag = "span";

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = console.readLine();
            BufferedReader fReader = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = fReader.readLine()) != null) {
                sb.append(line);
            }
            line = sb.toString();


            String startTag = "<" + tag;
            String endTag = "</" + tag + ">";
            int startIdx = -1;
            int endIdx;
            while (true) {
                startIdx = line.indexOf(startTag, startIdx + 1);
                if (startIdx == -1) {
                    break;
                }
                endIdx = line.indexOf(endTag, startIdx + tag.length() + 2);

                int tmpIdx = startIdx + tag.length() + 1;
                String tmp = line.substring(0, endIdx);
                while (true) {
                    tmpIdx = tmp.indexOf(startTag, tmpIdx + 1);
                    if (tmpIdx != -1) {
                        endIdx = line.indexOf(endTag, endIdx + endTag.length());
                        tmp = line.substring(0, endIdx);
                        continue;
                    }
                    break;
                }

                System.out.println(line.substring(startIdx, endIdx + tag.length() + 3));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
