package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        File rootDir = new File(root);
        stack.push(rootDir);
        while (!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isDirectory()) {
                for (File f : child.listFiles()) {
                    stack.push(f);
                }
            } else if (child.isFile()) {
                fileList.add(child.getAbsolutePath());
            }
        }
        return fileList;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileList = getFileTree("src/main/resources/level31/lesson02/home02");
        for (String s : fileList) {
            System.out.println(s);
        }
    }
}
