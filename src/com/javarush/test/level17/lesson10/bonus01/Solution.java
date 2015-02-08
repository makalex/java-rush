package com.javarush.test.level17.lesson10.bonus01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        //start here - начни тут
        if ("-c".equals(args[0])) {
            String name = args[1];
            Sex sex = "м".equals(args[2]) ? Sex.MALE : Sex.FEMALE;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date bd = dateFormat.parse(args[3]);
            Person person = (sex == Sex.MALE) ? Person.createMale(name, bd) : Person.createFemale(name, bd);

            allPeople.add(person);
            System.out.println(allPeople.size()-1);
        }
        else if ("-u".equals(args[0])) {
            int index = Integer.parseInt(args[1]);
            String name = args[2];
            Sex sex = "м".equals(args[3]) ? Sex.MALE : Sex.FEMALE;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date bd = dateFormat.parse(args[4]);

            Person person = allPeople.get(index);
            person.setName(name);
            person.setSex(sex);
            person.setBirthDay(bd);
        }
        else if ("-d".equals(args[0])) {
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            person.setName(null);
            person.setSex(null);
            person.setBirthDay(null);
        }
        else if ("-i".equals(args[0])) {
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);
            DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String bd = dateFormat.format(person.getBirthDay());

            System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " +  bd);
        }
    }
}
