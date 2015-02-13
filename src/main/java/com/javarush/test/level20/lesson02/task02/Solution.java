package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            File your_file_name = new File("src/main/resources/level20/lesson02/task02/test.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("alex");
            user1.setLastName("mak");
            user1.setMale(true);
            user1.setBirthDate(new Date());
            user1.setCountry(User.Country.UKRAINE);

            User user2 = new User();
            user2.setFirstName("alex2");
            user2.setLastName("mak2");
            user2.setMale(false);
            user2.setBirthDate(new Date());
            user2.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User user : loadedObject.users) {
                System.out.println(
                        user.getFirstName() + " " + user.getLastName() + " " + user.isMale() + " " +
                        user.getBirthDate() + " " + user.getCountry());
            }


            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter fWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            for (int i = 0; i < users.size(); i++) {
                fWriter.write("USER");
                fWriter.newLine();
                fWriter.write("\tFirstName:" + users.get(i).getFirstName());
                fWriter.newLine();
                fWriter.write("\tLastName:" + users.get(i).getLastName());
                fWriter.newLine();
                fWriter.write("\tMale:" + users.get(i).isMale());
                fWriter.newLine();
                fWriter.write("\tBD:" + users.get(i).getBirthDate().getTime());
                fWriter.newLine();
                fWriter.write("\tCountry:" + users.get(i).getCountry());
                fWriter.newLine();
            }
            fWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader fReader = new BufferedReader(new InputStreamReader(inputStream));
            User user;
            while ("USER".equals(fReader.readLine())) {
                user = new User();
                user.setFirstName(fReader.readLine().replace("\tFirstName:", ""));
                user.setLastName(fReader.readLine().replace("\tLastName:", ""));
                user.setMale(Boolean.valueOf(fReader.readLine().replace("\tMale:", "")));
                user.setBirthDate(new Date(Long.parseLong(fReader.readLine().replace("\tBD:", ""))));
                User.Country country;
                switch (fReader.readLine().replace("\tCountry:", "")) {
                    case "UKRAINE" :
                        country = User.Country.UKRAINE;
                        break;
                    case "RUSSIA" :
                        country = User.Country.RUSSIA;
                        break;
                    case "OTHER" :
                        country = User.Country.OTHER;
                        break;
                    default:
                        country = null;
                }
                user.setCountry(country);
                users.add(user);
            }
            fReader.close();
        }
    }
}
