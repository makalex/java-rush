package com.javarush.test.level20.lesson10.bonus01;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100_000_000)));
        System.out.println((System.currentTimeMillis() - start) / 1000 + " sec");
    }

    public static int[] getNumbers(int N) {
        int[][] pow_arr = new int[10][11];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                pow_arr[i][j] = (int) Math.pow(i, j);
            }
        }
        List<Integer> resultList = new LinkedList<>();
        byte digitsCount, digit;
        int sum, n2;
        for (int n = 1; n < N + 1; n++) {
            digitsCount = getDigitsCount(n);
            sum = 0;
            n2 = n;
            for (int j = 0; j < digitsCount; j++) {
                digit = (byte) (n2 % 10);
                sum = sum + pow_arr[digit][digitsCount];
                n2 /= 10;
            }

            if (n == sum) {
                resultList.add(n);
            }
        }

        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        return res;
    }

    static byte getDigitsCount(int n) {
        byte count = 0;
        if (0 <= n && n < 10) {
            count = 1;
        } else if (10 <= n && n < 100){
            count = 2;
        } else if (100 <= n && n < 1000){
            count = 3;
        } else if (1000 <= n && n < 10000){
            count = 4;
        } else if (10000 <= n && n < 100000){
            count = 5;
        } else if (100000 <= n && n < 1000000){
            count = 6;
        } else if (1000000 <= n && n < 10000000){
            count = 7;
        } else if (10000000 <= n && n < 100000000){
            count = 8;
        } else if (100000000 <= n && n < 1000000000){
            count = 9;
        } else if (1000000000 <= n && n < Integer.MAX_VALUE){
            count = 10;
        }
        return count;
    }
}
