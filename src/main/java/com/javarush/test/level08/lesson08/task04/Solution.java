package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("NOV 1 1980"));
        map.put("Сталлоне1", new Date("JUNE 1 1982"));
        map.put("Сталлоне2", new Date("JAN 1 1983"));
        map.put("Сталлоне3", new Date("JULY 1 1984"));
        map.put("Сталлоне4", new Date("JUNE 1 1985"));
        map.put("Сталлоне5", new Date("AUG 1 1986"));
        map.put("Сталлоне6", new Date("JUNE 1 1987"));
        map.put("Сталлоне7", new Date("JUNE 1 1988"));
        map.put("Сталлоне8", new Date("SEP 1 1980"));
        map.put("Сталлоне9", new Date("JUNE 1 1994"));

        //Напишите тут ваш код

        //removeAllSummerPeople(map);

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        for (Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator(); iter.hasNext();) {
            Map.Entry<String, Date> pair = iter.next();
            Date date = pair.getValue();
            int month = date.getMonth();
            if (4 < month && month < 8) {
                iter.remove();
            }
        }
    }
//
//    public static void main(String[] args) {
//        Map<String, Date> map = createMap();
//
//        for (Map.Entry<String, Date> pairs : map.entrySet()) {
//            System.out.println(pairs.getKey() + " / " + pairs.getValue());
//        }
//
//    }
}
