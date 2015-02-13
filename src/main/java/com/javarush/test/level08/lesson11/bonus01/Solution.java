package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here - напиши код тут
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String month = br.readLine();

        Date d = new Date(month + " 1 1991");

        int monthNumber = d.getMonth() + 1;

        System.out.println(month + " is " + monthNumber + " month");
    }

}
