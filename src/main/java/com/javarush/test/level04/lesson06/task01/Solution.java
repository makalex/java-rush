package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код

        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i1 = Integer.parseInt(br.readLine());
        int i2 = Integer.parseInt(br.readLine());

        if (i1 < i2)
            System.out.println(i1);
        else
            System.out.println(i2);
    }
}