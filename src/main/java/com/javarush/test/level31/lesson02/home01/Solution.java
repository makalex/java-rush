package com.javarush.test.level31.lesson02.home01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String dirPath = args[0];
        String resultFileAbsolutePath = args[1];

        List<String> fileNames = getFileList(dirPath);
    }

    public static List<String> getFileList(String root) throws IOException {
        List<String> fileList = new ArrayList<>();
        Stack<File> stack = new Stack<>();
        File rootDir = new File(root);
        stack.push(rootDir);
        while (!stack.isEmpty()) {
            File child = stack.pop();
            if (child.isDirectory()) {
                if (child.listFiles() == null) {
                    // 2.3 delete directory if it is empty
                    child.delete();
                } else {
                    for (File f : child.listFiles()) {
                        stack.push(f);
                    }
                }
            } else if (child.isFile()) {
                if (child.length() > 50) {
                    // 2.2 delete file if it's length > 50 bytes
                    child.delete();
                } else {
                    //
                    fileList.add(child.getAbsolutePath());
                }
            }
        }
        return fileList;
    }
}
