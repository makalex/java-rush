package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
*/
public class Solution {
    public static String getPartOfString(String string) {
        if (string == null)
            throw new TooShortStringException();

        int startIdx = string.indexOf(' ');
        if (startIdx < 0) throw new TooShortStringException();
        int endIdx = string.indexOf(' ');
        endIdx = string.indexOf(' ', endIdx  + 1);
        if (endIdx < 0)  throw new TooShortStringException();
        endIdx = string.indexOf(' ', endIdx  + 1);
        if (endIdx < 0)  throw new TooShortStringException();
        endIdx = string.indexOf(' ', endIdx + 1);
        if (endIdx < 0)  throw new TooShortStringException();
        endIdx = string.indexOf(' ', endIdx + 1);
        if (endIdx < 0)  throw new TooShortStringException();

        return string.substring(startIdx + 1, endIdx);
    }

    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        //System.out.println(getPartOfString("JavaRush - лучший"));
        System.out.println(getPartOfString(null));
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException() {
            super();
        }
    }
}
