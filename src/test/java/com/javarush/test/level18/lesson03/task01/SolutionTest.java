package com.javarush.test.level18.lesson03.task01;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class SolutionTest {

    static InputStream oldSystemIn = System.in;
    static PrintStream oldSystemOut = System.out;

    @Test
    public void testMain() throws Exception {
        String fileName = "src/test/resources/level18/lesson03/task01/t1.txt";

        // set new System.in and System.out streams
        System.setIn(new ByteArrayInputStream(fileName.getBytes()));
        ByteArrayOutputStream newSystemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newSystemOut));


        new Solution().main(null);


        // restore old System.in and System.out streams
        System.setIn(oldSystemIn);
        System.setOut(oldSystemOut);


        String expected = "115";
        String actual =
                new BufferedReader(
                        new InputStreamReader(
                                new ByteArrayInputStream(newSystemOut.toByteArray()))).readLine();

        Assert.assertEquals(expected, actual);
    }
}