package com.javarush.test.level22.lesson05.task02;


/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(getPartOfString("\t\t"));
    }
    public static String getPartOfString(String string) throws TooShortStringException {

        String result = null;

        try {
            int startIdx = string.indexOf('\t');
            int endIdx = string.indexOf('\t', startIdx + 1);
            result = string.substring(startIdx + 1, endIdx);
        }
        catch (Exception e) {
            throw new TooShortStringException();
        }

        return result;
    }

    public static class TooShortStringException extends Exception {
    }
}
