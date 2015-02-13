package com.javarush.test.level19.lesson10.bonus03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    static InputStream oldSystemIn = System.in;
    static PrintStream oldSystemOut = System.out;

    @Test
    public void testMain1() throws Exception {
        String fileName = "resources/level19/lesson10/bonus03/t1.txt";

        // set new System.in and System.out streams
        System.setIn(new ByteArrayInputStream(fileName.getBytes()));
        ByteArrayOutputStream newSystemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newSystemOut));

        String tag = "span";
        new Solution().main(new String[]{ tag });

        // restore old System.in and System.out streams
        System.setIn(oldSystemIn);
        System.setOut(oldSystemOut);


        // expected result
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("<span><span>T1uranga Leela</span><span>T2uranga Leela</span></span>");
        expectedList.add("<span>T1uranga Leela</span>");
        expectedList.add("<span>T2uranga Leela</span>");
        expectedList.add("<span>Turanga Leela</span>");


        // actual result
        List<String> actualList = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(newSystemOut.toByteArray())));
        while (reader.ready()) {
            actualList.add(reader.readLine());
        }

        Assert.assertEquals(expectedList, actualList);
    }
}