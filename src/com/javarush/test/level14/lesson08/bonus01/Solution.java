package com.javarush.test.level14.lesson08.bonus01;

import sun.net.ftp.FtpLoginException;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.rmi.activation.ActivateFailedException;
import java.text.ParseException;
import java.util.*;
import java.util.regex.PatternSyntaxException;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        }
        catch (Exception e) {
            exceptions.add(e);
        }
        //Add your code here
        exceptions.add(new NullPointerException());
        exceptions.add(new IllegalArgumentException());
        exceptions.add(new FileAlreadyExistsException(""));
        exceptions.add(new FileNotFoundException());
        exceptions.add(new ActivateFailedException(""));
        exceptions.add(new FtpLoginException(""));
        exceptions.add(new PatternSyntaxException("","",1));
        exceptions.add(new ParseException("",1));
        exceptions.add(new NoSuchElementException());
    }
}
