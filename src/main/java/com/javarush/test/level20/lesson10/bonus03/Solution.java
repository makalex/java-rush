package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endX) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> res = detectAllWords(crossword, "home", "same", "poe");
        for (Word word : res) {
            System.out.println(word);
        }

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<Word>();
        for (String word : words) {
            result.add(detectWord(crossword, word));
        }
        return result;
    }

    static Word detectWord(int[][] crossword, String word) {
        int m = crossword.length;
        int n = crossword[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((char) crossword[i][j] == word.charAt(0)) {
                    int[] endPoint = findEnd(crossword, word, i, j, 0);
                    if (endPoint != null) {
                        Word wordRes = new Word(word);
                        wordRes.setStartPoint(j, i);
                        wordRes.setEndPoint(endPoint[1], endPoint[0]);
                        return wordRes;
                    }
                }
            }
        }

        return null;
    }

    static int[] findEnd(int[][] crossword, String word, int i, int j, int idx) {
        boolean endFound;
        int iNext, jNext;

        // left
        endFound = true;
        iNext = i; jNext = j;
        for (int k = 1; k < word.length(); k++) {
            if (!checkNext(crossword, word.charAt(k), iNext, --jNext)) {
                endFound = false;
                break;
            }
        }

        // left top
        if (!endFound) {
            endFound = true;
            iNext = i; jNext = j;
            for (int k = 1; k < word.length(); k++) {
                if (!checkNext(crossword, word.charAt(k), --iNext, --jNext)) {
                    endFound = false;
                    break;
                }
            }

        }

        // top
        if (!endFound) {
            endFound = true;
            iNext = i; jNext = j;
            for (int k = 1; k < word.length(); k++) {
                if (!checkNext(crossword, word.charAt(k), --iNext, jNext)) {
                    endFound = false;
                    break;
                }
            }
        }

        // top right
        if (!endFound) {
            endFound = true;
            iNext = i; jNext = j;
            for (int k = 1; k < word.length(); k++) {
                if (!checkNext(crossword, word.charAt(k), --iNext, ++jNext)) {
                    endFound = false;
                    break;
                }
            }
        }


        // right
        if (!endFound) {
            endFound = true;
            iNext = i; jNext = j;
            for (int k = 1; k < word.length(); k++) {
                if (!checkNext(crossword, word.charAt(k), iNext, ++jNext)) {
                    endFound = false;
                    break;
                }
            }
        }


        // right bottom
        if (!endFound) {
            endFound = true;
            iNext = i; jNext = j;
            for (int k = 1; k < word.length(); k++) {
                if (!checkNext(crossword, word.charAt(k), ++iNext, ++jNext)) {
                    endFound = false;
                    break;
                }
            }
        }

        // bottom
        if (!endFound) {
            endFound = true;
            iNext = i; jNext = j;
            for (int k = 1; k < word.length(); k++) {
                if (!checkNext(crossword, word.charAt(k), ++iNext, jNext)) {
                    endFound = false;
                    break;
                }
            }
        }

        // bottom left
        if (!endFound) {
            endFound = true;
            iNext = i; jNext = j;
            for (int k = 1; k < word.length(); k++) {
                if (!checkNext(crossword, word.charAt(k), ++iNext, --jNext)) {
                    endFound = false;
                    break;
                }
            }
        }

        if (endFound) {
            return new int[] {iNext, jNext};
        }

        return null;
    }

    static boolean checkNext(int[][] crossword, char nextChar, int i, int j) {
        if ( i < 0 || j < 0 || i >= crossword.length || j >= crossword[0].length ) {
            return false;
        }
        if ((char)crossword[i][j] == nextChar) {
            return true;
        }
        return false;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
