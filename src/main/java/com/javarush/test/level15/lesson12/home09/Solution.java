package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    //String url = "http://kvhosa02.delta.internal:9080/saserver/api/auth/pwd?name1=asd&name2=123&obj=1.2";
    //String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
    //String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
    //String url = "http://javarush.ru/alpha/index.html?obj=14&name=Amigo";
    //String url = "http://javarush.ru/alpha/index.html?obj=pp.14&name=Amigo";

    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        String params = url.substring(url.indexOf('?') + 1, url.length());

        List<String> paramNameList = new ArrayList<String>();

        boolean foundObjParam = false;
        String paramName, paramValue = null;
        for (String p : params.split("&")) {
            paramName = p.substring(0, ( p.indexOf('=') >= 0 ) ? p.indexOf('=') : p.length());
            paramNameList.add(paramName);

            if (paramName.equals("obj")) {
                foundObjParam = true;
                paramValue = p.substring(p.indexOf('=') + 1, p.length());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String param : paramNameList) {
            sb.append(param).append(" ");
        }
        // remove last space
        sb.replace(sb.length() - 1, sb.length(), "");

        // print params separated with space
        System.out.println(sb.toString());


        if (foundObjParam) {
            try {
                alert(Double.parseDouble(paramValue));
            }
            catch (NumberFormatException e) {
                alert(paramValue);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
