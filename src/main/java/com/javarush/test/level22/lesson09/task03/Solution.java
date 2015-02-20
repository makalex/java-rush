package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {

    public static void main(String[] args) {
        try {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = console.readLine();
            BufferedReader fReader = new BufferedReader(new FileReader(fileName));
            List<String> wordsList = new ArrayList<>();
            while (fReader.ready()) {
                String[] splitted = fReader.readLine().split(" ");
                wordsList.addAll(Arrays.asList(splitted));
            }
            fReader.close();

            StringBuilder result = getLine(wordsList.toArray(new String[wordsList.size()]));
            System.out.println(result.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        // src/test/resources/level22/lesson09/task03/t5.txt
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) {
            return sb;
        }

        ArrayList<String> originalWordsList = new ArrayList<>(Arrays.asList(words));
        ArrayList<String> result = null;

        ArrayList<String> wordsList1 = (ArrayList) originalWordsList.clone();
        boolean foundFullChain = false;
        int rebuildCount = 0;
        while (rebuildCount < originalWordsList.size()) {
            int firstWordIdx = 0;
            while (!foundFullChain && firstWordIdx < originalWordsList.size()) {
                ArrayList<String> wordsList2 = (ArrayList) wordsList1.clone();
                result = new ArrayList<>();

                String currentWord = wordsList2.get(firstWordIdx);
                wordsList2.remove(firstWordIdx);
                result.add(currentWord);

                String lastChar = currentWord.substring(currentWord.length() - 1);
                String firstChar;
                boolean foundNext = true;
                while (wordsList2.size() > 0 && foundNext) {
                    foundNext = false;
                    for (int i = 0; i < wordsList2.size(); i++) {
                        currentWord = wordsList2.get(i);
                        firstChar = currentWord.substring(0, 1);
                        if (firstChar.equalsIgnoreCase(lastChar)) {
                            result.add(currentWord);
                            lastChar = currentWord.substring(currentWord.length() - 1);
                            wordsList2.remove(i);
                            foundNext = true;
                            break;
                        }
                    }
                }
                firstWordIdx++;
                if (result.size() == originalWordsList.size()) {
                    foundFullChain = true;
                    break;
                }
            }

            if (result.size() == originalWordsList.size()) {
                break;
            }

            rebuildCount++;
            wordsList1.add(wordsList1.get(0));
            wordsList1.remove(0);
        }

        if (result != null) {
            for (String word : result) {
                sb.append(word).append(" ");
            }
            if (sb.length() > 0) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
        }
        return sb;
    }
}
