package com.javarush.test.level19.lesson03.task04;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1978

Подсказка: воспользуйтесь классом Calendar
*/

public class Solution {

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            String line = scanner.nextLine();
            String[] arr = line.split(" ");
            String firstName = arr[1];
            String middleName = arr[2];
            String lastName = arr[0];
            int year = Integer.parseInt(arr[5]);
            int month = Integer.parseInt(arr[4]) - 1;
            int day = Integer.parseInt(arr[3]);
            Calendar calendar = new GregorianCalendar(year, month, day);
            return new Person(firstName, middleName, lastName, calendar.getTime());
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
