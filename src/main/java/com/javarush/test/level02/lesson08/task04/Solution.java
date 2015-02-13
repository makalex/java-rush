package com.javarush.test.level02.lesson08.task04;

/* Минимум четырех чисел
Написать функцию, которая вычисляет минимум из четырёх чисел.
Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
Подсказка:
Нужно написать тело обеих существующих функций min и исправить их возвращаемые значения.
*/
public class Solution
{
    public static int min(int a, int b, int c, int d)
    {
        //Напишите тут ваш код
        int min = a;
        if (a < min) min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;

        return min;
    }

    public static int min(int a, int b)
    {
        //Напишите тут ваш код
        if (a < b) return a;
        else return b;
    }

    public static void main(String[] args) throws Exception
    {
        if (min(5, 8, 6, 6) != 5)
        {
            System.out.println("1) Неправильно для a"); //вывод=5
        }
        if (min(-1, -3, -2, -5) != -5)
        {
            System.out.println("2) Неправильно для отрицательных чисел"); //вывод=-5
        }
        if (min(10, 5, 20, 42) != 5)
        {
            System.out.println("3) Неправильно для b"); //вывод=5
        }
        if (min(5, 5, 5, 5) != 5)
        {
            System.out.println("4) Неправильно для всех равных чисел"); //вывод=5
        }
        if (min(8, 7, 5, 6) != 5)
        {
            System.out.println("5) Неправильно для c"); //вывод=5
        }
        if (min(8, 7, 5, 5) != 5)
        {
            System.out.println("6) Неправильно для равных c и d"); //вывод=5
        }
        if (min(5, 5, 6, 6) != 5)
        {
            System.out.println("7) Неправильно для равных двух пар"); //вывод=5
        }
    }
}