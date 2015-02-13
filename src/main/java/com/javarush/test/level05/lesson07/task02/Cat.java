package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен,
то нужно указать какой-нибудь средний вес. Кот не может ничего не весить.
То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    String name;
    int age;
    int weight;
    String color;
    String address;

    private static int DEF_WEIGHT = 5;
    private static int DEF_AGE = 1;

    public void initialize(String name) {
        this.name = name;
        this.age = DEF_AGE;
        this.weight = DEF_WEIGHT;
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = DEF_WEIGHT;
    }

    public void initialize(int weight, String color) {
        this.age = DEF_AGE;
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String address) {
        this.age = DEF_AGE;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }
}
