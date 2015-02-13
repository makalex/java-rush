package com.javarush.test.level02.lesson08.task03;

/* Минимум трех чисел
Написать функцию, которая вычисляет минимум из трёх чисел.
Подсказка:
Нужно написать тело существующей функции min и исправить возвращаемое значение.
*/
public class Solution {
    public static int min(int a, int b, int c) {
        //Напишите тут ваш код
        int min = a;

        if (b < min)
            min = b;
        if (c < min)
            min = c;

        return min;
    }

    public static void main(String[] args) throws Exception {
        if (min(5, 8, 6) != 5) {
            System.out.println("1) Неправильно для a"); //вывод=5
        }
        if (min(5, 6, 8) != 5) {
            System.out.println("2) Неправильно для a"); //вывод=5
        }
        if (min(-3, -5, -2) != -5) {
            System.out.println("3) Неправильно для отрицательных чисел"); //вывод=-5
        }
        if (min(10, 5, 20) != 5) {
            System.out.println("4) Неправильно для b"); //вывод=5
        }
        if (min(20, 5, 10) != 5) {
            System.out.println("5) Неправильно для b"); //вывод=5
        }
        if (min(5, 5, 5) != 5) {
            System.out.println("6) Неправильно для всех равных чисел"); //вывод=5
        }
        if (min(8, 7, 5) != 5) {
            System.out.println("7) Неправильно для c"); //вывод=5
        }
        if (min(7, 8, 5) != 5) {
            System.out.println("8) Неправильно для c"); //вывод=5
        }
        if (min(5, 5, 6) != 5) {
            System.out.println("9) Неправильно для пары равных чисел"); //вывод=5
        }
    }

}