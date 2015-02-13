package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));

        StringBuilder name;
        int year, month, day;
        String line;
        while ((line = fReader.readLine()) != null) {
            String[] rec = line.split(" ");
            year = Integer.parseInt(rec[rec.length - 1]);
            month = Integer.parseInt(rec[rec.length - 2]) - 1;
            day = Integer.parseInt(rec[rec.length - 3]);
            name = new StringBuilder();
            for (int i = 0; i < rec.length - 3; i++) {
                name.append(rec[i]).append(" ");
            }
            name.replace(name.length() - 1, name.length(), "");

            PEOPLE.add(new Person(name.toString(), new GregorianCalendar(year, month, day).getTime()));
        }
        fReader.close();
    }
}
