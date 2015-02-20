package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример, "мор"-"ром", "трос"-"сорт"
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        // src/test/resources/level22/lesson09/task01/t1.txt
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        Set<String> uniqueWords = new HashSet<>();
        while (fReader.ready()) {
            String[] splitterWords = fReader.readLine().split(" ");
            uniqueWords.addAll(Arrays.asList(splitterWords));
        }
        fReader.close();

        List<String> pairedWordsList = new ArrayList<>();
        Iterator<String> iter = uniqueWords.iterator();
        while (iter.hasNext()) {
            String word = iter.next();
            String reversedWord = new StringBuilder(word).reverse().toString();
            iter.remove();
            if (uniqueWords.contains(reversedWord)) {
                pairedWordsList.add(word);
            }
        }

        for (String word : pairedWordsList) {
            Pair pair = new Pair();
            pair.first = word;
            pair.second = new StringBuilder(word).reverse().toString();
            result.add(pair);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}
