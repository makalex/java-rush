package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //Напишите тут ваш код
        StringBuilder sb = new StringBuilder();
        char previousChar, currentChar;


        // process first character
        //
        currentChar = s.charAt(0);
        if (currentChar != ' ')
            sb.append(Character.toUpperCase(currentChar));
        else
            sb.append(currentChar);


        //process rest chars
        //
        for (int i = 1; i < s.length(); i++) {
            previousChar = s.charAt(i-1);
            currentChar = s.charAt(i);
            if (previousChar == ' ' && currentChar != ' ')
                sb.append(Character.toUpperCase(currentChar));
            else
                sb.append(currentChar);
        }

        System.out.println(sb.toString());
    }


}
