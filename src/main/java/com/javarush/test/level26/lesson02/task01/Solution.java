package com.javarush.test.level26.lesson02.task01;

import java.util.*;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        //System.out.println(Arrays.toString(array));

        int n = array.length;
        double mediana = n % 2 == 1
                ? array[n / 2]
                : (double)(array[n / 2 - 1] + array[n / 2]) / 2;

        //System.out.println(mediana);

        // distance
        Map<Double, int[]> map = new TreeMap<>();
        for (Integer i : array) {
            double distance = Math.abs(mediana - i);
            if (map.containsKey(distance)) {
                int[] newArr = new int[map.get(distance).length + 1];
                System.arraycopy(map.get(distance), 0, newArr, 0, map.get(distance).length);
                newArr[map.get(distance).length] = i;
                map.put(distance, newArr);
            } else {
                map.put(distance, new int[]{i});
            }
        }

        Integer[] result = new Integer[n];
        int i = 0;
        for (Map.Entry<Double, int[]> pair : map.entrySet()) {
            int[] arr = pair.getValue();
            Arrays.sort(arr);
            for (int value : arr) {
                result[i++] = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] array1 = {13,8,15,5,17};
        System.out.println(Arrays.toString(sort(array1)));

        Integer[] array2 = {8,15,5,17};
        System.out.println(Arrays.toString(sort(array2)));
    }
}
