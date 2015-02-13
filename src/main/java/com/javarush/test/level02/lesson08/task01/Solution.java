package com.javarush.test.level02.lesson08.task01;

/* Минимум двух чисел
Написать функцию, которая возвращает минимум из двух чисел.
Подсказка:
Нужно написать тело существующей функции min и исправить возвращаемое значение.
*/
public class Solution
{
    public static int min(int a, int b)
    {
        //Напишите тут ваш код
        if (a < b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) throws Exception
    {
        if (min(5, 8) != 5)
        {
            System.out.println("1) Неправильно для a"); //вывод=5
        }
        if (min(-2, -5) != -5)
        {
            System.out.println("2) Неправильно для отрицательных чисел"); //вывод=-5
        }
        if (min(10, 5) != 5)
        {
            System.out.println("3) Неправильно для b"); //вывод=5
        }
        if (min(5, 5) != 5)
        {
            System.out.println("4) Неправильно для всех равных чисел"); //вывод=5
        }
    }

}