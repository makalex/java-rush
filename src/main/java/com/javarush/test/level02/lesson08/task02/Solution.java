package com.javarush.test.level02.lesson08.task02;

/* Максимум двух чисел
Написать функцию, которая вычисляет максимум из двух чисел.
Подсказка:
Нужно написать тело существующей функции max и исправить возвращаемое значение.
*/
public class Solution
{
    public static int max(int a, int b)
    {
        //Напишите тут ваш код
        if (a > b) return a;
        else return b;
    }

    public static void main(String[] args) throws Exception
    {
        if (max(5, 3) != 5)
        {
            System.out.println("1) Неправильно для a"); //вывод=5
        }
        if (max(-7, -5) != -5)
        {
            System.out.println("2) Неправильно для отрицательных чисел"); //вывод=-5
        }
        if (max(1, 5) != 5)
        {
            System.out.println("3) Неправильно для b"); //вывод=5
        }
        if (max(5, 5) != 5)
        {
            System.out.println("4) Неправильно для всех равных чисел"); //вывод=5
        }
    }

}