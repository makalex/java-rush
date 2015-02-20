package com.javarush.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Externalizable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by MakarytskyiO on 19.01.2015.
 */
public class Test {
    public static void main(String[] args) throws Exception {

//        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//        for (StackTraceElement s : ste) {
//            System.out.println(s.getMethodName());
//        }

        //Logger logger = LoggerFactory.getLogger(Test.class);
        //logger.info("Hello");
        //Class<?> clazz = Class.forName("java.lang.Integer");
        //System.out.println(clazz.newInstance());

        // System.out.println(Charset.defaultCharset());

        System.out.println(Double.toHexString(123));
        System.out.println(Integer.toBinaryString(1111111223));

        List<Integer> in = new ArrayList<>();
        in.add(12);
        List<?> list = new ArrayList<>(in);
        list.get(0);
    }



    static void printAvailableCharsets() {
        Map<String, Charset> encodings = Charset.availableCharsets();
        for (Map.Entry<String, Charset> enc : encodings.entrySet()) {
            System.out.println(enc.getKey() + " " + enc.getValue().aliases());
        }
    }

    static void isStringShareChars() throws Exception {
        String s = "abcdefghij".substring(2, 5);
        int logicalLength = s.length();
        int valueLength = getValueLength(s);

        System.out.printf("%d %d ", logicalLength, valueLength);
        if (logicalLength != valueLength) {
            System.out.println("shared");
        } else {
            System.out.println("unshared");
        }
    }

    static int getValueLength(String s) throws Exception {
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        return ((char[])field.get(s)).length;
    }
}
