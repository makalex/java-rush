package com.javarush.test.level31.lesson10.home01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/* Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.
Подсказка: возможно, Вам понадобится File.separator.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/main/java/com/javarush/test/level31/lesson10/home01/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/main/java/com/javarush/test/level31/lesson10/home01/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/main/java/com/javarush/test/level31/lesson10/home01/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();

        boolean loadFromXmlSuccessfully;
        try {
            FileInputStream fin = new FileInputStream(fileName);
            // stream is closed after this method returns
            properties.loadFromXML(fin);
            loadFromXmlSuccessfully = true;
        }
        catch (IOException e) {
            loadFromXmlSuccessfully = false;
        }

        if (!loadFromXmlSuccessfully) {
            FileInputStream fin = null;
            try {
                fin = new FileInputStream(fileName);
                // !!! stream remains open after this method returns
                properties.load(fin);
            }
            catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fin.close();
                }
                catch (IOException e) {}
            }
        }

        return properties;
    }
}
