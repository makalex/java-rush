package com.javarush.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MakarytskyiO on 19.01.2015.
 */
public class Test {
    public static void main(String[] args) {

//        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
//        for (StackTraceElement s : ste) {
//            System.out.println(s.getMethodName());
//        }

//        ss();

        //CharSequence st1, st = new String("asd");
        //System.out.println(st.getClass());

        //int i = 13223;
        //byte b = (byte)i;

        //System.out.println("asd "+null);
        //Object o = "asd";
        //System.out.println(o.toString());

        //int a = 1, b = 2;
        //float f = (float) a / b;
        //System.out.println(f);
        //new Date().toInstant();

        System.out.println(Runtime.getRuntime().availableProcessors());


        Logger logger = LoggerFactory.getLogger(Test.class);
        logger.info("Hello");
    }


}
