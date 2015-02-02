package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //Написать тут ваш код
        Human child1 = new Human("child1", true, 12, new ArrayList<Human>());
        Human child2 = new Human("child1", true, 13, new ArrayList<Human>());
        Human child3 = new Human("child1", false, 14, new ArrayList<Human>());

        ArrayList<Human> childs1 = new ArrayList<Human>();
        childs1.add(child1);
        childs1.add(child2);
        childs1.add(child3);
        Human father = new Human("father", true, 45, childs1);
        Human mother = new Human("mother", false, 78, childs1);

        ArrayList<Human> childs2 = new ArrayList<Human>();
        childs2.add(father);
        Human dad1 = new Human("dad1", true, 75, childs2);
        Human bab1 = new Human("bab1", false, 77, childs2);

        ArrayList<Human> childs3 = new ArrayList<Human>();
        childs3.add(mother);

        Human dad2 = new Human("dad2", true, 76, childs3);
        Human bab2 = new Human("bab2", false, 78, childs3);


        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);

        System.out.println(father);
        System.out.println(mother);

        System.out.println(dad1);
        System.out.println(dad2);
        System.out.println(bab1);
        System.out.println(bab2);
    }

    public static class Human {
        //Написать тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
