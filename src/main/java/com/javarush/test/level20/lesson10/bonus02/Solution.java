package com.javarush.test.level20.lesson10.bonus02;

/* Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");

        byte[][] a2 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 1}
        };
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 3");

        byte[][] a3 = new byte[][]{
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1}

        };
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int n = a.length; // assume we have square array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    clearRectangle(i, j, a);
                    count++;
                }
            }
        }
        return count;
    }

    static void clearRectangle(int I, int J, byte[][] arr) {
        int n = arr.length;

        // find right bottom corner
        int jRight = 0;
        for (int k = J; k < n; k++) {
            if (arr[I][k] == 0) {
                jRight = k;
                break;
            }
            // if it is the last element
            if (k == n - 1) {
                jRight = k;
            }
        }

        // find right bottom corner
        int iBottom = 0;
        for (int k = I; k < n; k++) {
            if (arr[k][J] == 0) {
                iBottom = k;
                break;
            }
            // if it is last element
            if (k == n - 1) {
                iBottom = k;
            }
        }

        for (int ii = I; ii <= iBottom; ii++) {
            for (int jj = J; jj <= jRight; jj++) {
                arr[ii][jj] = 0;
            }
        }
    }
}
