package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

//    public static void main(String[] args) {
//        DataAdapter da = new DataAdapter(new Customer() {
//            @Override
//            public String getCompanyName() {
//                return "JavaRush Ltd.";
//            }
//
//            @Override
//            public String getCountryName() {
//                return "Ukraine";
//            }
//        },
//        new Contact() {
//            @Override
//            public String getName() {
//                return "Ivanov, Ivan";
//            }
//
//            @Override
//            public String getPhoneNumber() {
//                return "+38(050)123-45-67";
//            }
//        });
//        System.out.println(da.getCountryCode());
//        System.out.println(da.getCompany());
//        System.out.println(da.getContactFirstName());
//        System.out.println(da.getContactLastName());
//        System.out.println(da.getDialString());
//    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryName = customer.getCountryName();
            String countryCode = null;
            for (Map.Entry<String, String> pairs : countries.entrySet()) {
                if (pairs.getValue().equals(countryName)) {
                    countryCode = pairs.getKey();
                    break;
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String name = contact.getName();
            return name.substring(name.indexOf(',') + 2, name.length());
        }

        @Override
        public String getContactLastName() {
            String name = contact.getName();
            return name.substring(0, name.indexOf(','));
        }

        @Override
        public String getDialString() {
            return "callto://" + contact.getPhoneNumber().replace("(", "").replace(")", "").replace("-", "");
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}