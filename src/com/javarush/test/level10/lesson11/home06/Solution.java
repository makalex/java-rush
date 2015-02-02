package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String firstName;
        String lastName;
        int age;
        Date birthday;
        Human mother;
        Human father;

        public Human(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, String lastName, int age, Date birthday) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.birthday = birthday;
        }

        public Human(Human mother, String firstName, String lastName, int age, Date birthday) {
            this.mother = mother;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.birthday = birthday;
        }

        public Human(String firstName, int age) {

            this.firstName = firstName;
            this.age = age;
        }

        public Human(String firstName, String lastName, Human mother, Human father) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.mother = mother;
            this.father = father;
        }

        public Human(Human mother, Human father) {
            this.mother = mother;
            this.father = father;
        }

        public Human(String firstName) {
            this.firstName = firstName;
        }

        public Human(int age, Date birthday) {
            this.age = age;
            this.birthday = birthday;
        }

        public Human(Date birthday) {
            this.birthday = birthday;
        }
    }
}
