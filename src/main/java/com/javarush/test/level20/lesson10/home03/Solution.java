package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
*/
public class Solution implements Serializable {

    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/level20/lesson10/task03/t1.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        Solution s = new Solution();
        B b = s.new B("aa");
        oos.writeObject(b);
        oos.close();

        B loadedB;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        loadedB = (B) ois.readObject();
        ois.close();

        System.out.println(b.name);
        System.out.println(loadedB.name);
    }

    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A() {}
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            name = (String) in.readObject();
        }
    }
}
