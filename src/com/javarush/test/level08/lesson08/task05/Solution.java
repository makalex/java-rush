package com.javarush.test.level08.lesson08.task05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "3");
        map.put("6", "2");
        map.put("7", "2");
        map.put("8", "7");
        map.put("9", "8");
        map.put("10", "3");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {

        //Напишите тут ваш код
        Collection<String> firstNames = map.values();

        Map<String, Integer> occurrence = new HashMap<String, Integer>();

        for (String name : firstNames) {
            if (occurrence.containsKey(name)) {
                occurrence.put(name, occurrence.get(name) + 1);
            } else {
                occurrence.put(name, 1);
            }
        }


        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> pair = iter.next();
            if (occurrence.get(pair.getValue()) > 1)
                iter.remove();
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> pair = iter.next();
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
