package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("name", "Ivanov");
        params.put("country", "UA");
        params.put("city", "Kiev");
        params.put("age", null);
        System.out.println(getCondition(params).toString());

        Map<String, String> params_2 = new LinkedHashMap<>();
        params.put("city", null);
        params.put("age", null);
        System.out.println(getCondition(params_2).toString());
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            if (param.getValue() != null) {
                sb.append(param.getKey()).append(" = '").append(param.getValue()).append("' and ");
            }
        }
        // remove last " and " substring
        if (sb.length() > 0) {
            sb.replace(sb.length() - 5, sb.length(), "");
        }
        return sb;
    }
}
