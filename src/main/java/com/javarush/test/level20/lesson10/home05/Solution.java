package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person.
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        String fileName = "src/main/resources/level20/lesson10/task05/t1.txt";
        Person person = new Person("firstName", "lastName", "UA", Sex.FEMALE);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
        oos.writeObject(person);
        oos.close();

        System.out.println(
                person.firstName + "\n" +
                person.lastName + "\n" +
                person.fullName + "\n" +
                person.greetingString + "\n" +
                person.country + "\n" +
                person.sex + "\n" +
                person.outputStream + "\n" +
                person.logger + "\n"
        );

        Person loadedPerson;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        loadedPerson = (Person) ois.readObject();
        ois.close();

        System.out.println(
                loadedPerson.firstName + "\n" +
                loadedPerson.lastName + "\n" +
                loadedPerson.fullName + "\n" +
                loadedPerson.greetingString + "\n" +
                loadedPerson.country + "\n" +
                loadedPerson.sex + "\n" +
                loadedPerson.outputStream + "\n" +
                loadedPerson.logger
        );
    }

    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }


    enum Sex {
        MALE,
        FEMALE
    }
}
