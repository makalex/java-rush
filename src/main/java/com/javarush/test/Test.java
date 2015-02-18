package com.javarush.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Externalizable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Class<?> clazz = Class.forName("java.lang.Integer");
        System.out.println(clazz.newInstance());

    }
}
