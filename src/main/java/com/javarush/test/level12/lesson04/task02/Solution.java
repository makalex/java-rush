package com.javarush.test.level12.lesson04.task02;

/* print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution
{
    public static void main(String[] args)
    {
        int i1 = 1;
        Integer i2 = 12;
        print(i1);
        print(i2);
    }

    //Напишите тут ваши методы

    static void print(int i) {
       // System.out.println("int");
    }
    static void print(Integer i) {
        //System.out.println("Integer");
    }
}
