package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    private static final long serialVersionUID = 123L;

    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName1 = "src/main/resources/level20/lesson10/task07/t1.txt";
        String fileName2 = "src/main/resources/level20/lesson10/task07/t2.txt";
        Solution solution = new Solution(fileName1);
        solution.writeObject("asdasd");
        solution.close();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName2));
        oos.writeObject(solution);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName2));
        Solution loadedObject = (Solution)ois.readObject();
        ois.close();

    }
}
