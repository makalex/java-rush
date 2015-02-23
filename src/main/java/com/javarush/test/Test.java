package com.javarush.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Externalizable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
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
        // printMessageFormat();


        System.out.println(sleepInterval(1));
        System.out.println(sleepInterval(10));
        System.out.println(sleepInterval(11));
        System.out.println(sleepInterval(23));
    }

    public static int sleepInterval(int snakeLen) {
        int pause = 500 - (int) Math.round((snakeLen - 1) * 22.2);
        pause = pause < 200 ? 200 : pause;
        return pause;
    }

    static void printMessageFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, new Date().getTime()};
        String[] filepart = {"closed {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform, null, null, null};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        Date date = new Date();
        Object[] testArgs = {"name", "symbol", 123.2, 1234.4, 33.3, date, date.getTime()};
        System.out.println(pattform.format(testArgs));
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
