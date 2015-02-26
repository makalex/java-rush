package com.javarush.test.level26.lesson02.task03;

import java.util.*;

/* Убежденному убеждать других не трудно.
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напишите public static компаратор CustomizedComparator, который будет:
1. в конструкторе принимать список компараторов
2. сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т
В конструктор передается как минимум один компаратор
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {

        private Comparator<T>[] comparatorList;

        public CustomizedComparator(Comparator<T>[] comparatorList) {
            this.comparatorList = comparatorList;
        }

        @Override
        public int compare(T o1, T o2) {
            int result = 0;
            for (Comparator<T> comparator : comparatorList) {
                result = comparator.compare(o1, o2);
                if (result != 0) {
                    break;
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {
        class Record {
            private int column1;
            private int column2;
            private String column3;
            private String column4;

            public Record(int column1, int column2, String column3, String column4) {
                this.column1 = column1;
                this.column2 = column2;
                this.column3 = column3;
                this.column4 = column4;
            }

            @Override
            public String toString() {
                return String.format("%2d %2d %2s %2s", column1, column2, column3, column4);
            }
        }

        Comparator<Record> comparator1 = new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.column1 - o2.column1;
            }
        };

        Comparator<Record> comparator2 = new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.column2 - o2.column2;
            }
        };

        Comparator<Record> comparator3 = new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.column3.compareTo(o2.column3);
            }
        };

        Comparator<Record> comparator4 = new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.column4.compareTo(o2.column4);
            }
        };


        Comparator<Record>[] comparatorsArray = new Comparator[4];
        comparatorsArray[0] = comparator1;
        comparatorsArray[1] = comparator2;
        comparatorsArray[2] = comparator3;
        comparatorsArray[3] = comparator4;

        CustomizedComparator<Record> customizedComparator = new CustomizedComparator<>(comparatorsArray);

        List<Record> recordList = new ArrayList<>();
        recordList.add(new Record(2,  3,  "a", "b"));
        recordList.add(new Record(2,  3,  "b", "a"));
        recordList.add(new Record(2,  3,  "b", "k"));
        recordList.add(new Record(2,  3,  "b", "c"));
        recordList.add(new Record(4,  1,  "g", "b"));
        recordList.add(new Record(12, 14, "y", "b"));
        recordList.add(new Record(1,  7,  "w", "b"));
        recordList.add(new Record(4,  4,  "d", "b"));
        recordList.add(new Record(2,  3,  "t", "b"));
        recordList.add(new Record(2,  8,  "a", "b"));

        System.out.println("\nBefore sorting...");
        for (Record record : recordList) {
            System.out.println(record);
        }

        Collections.sort(recordList, customizedComparator);

        System.out.println("\nAfter sorting...");
        for (Record record : recordList) {
            System.out.println(record);
        }
    }
}
