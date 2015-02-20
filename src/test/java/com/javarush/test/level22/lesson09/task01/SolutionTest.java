package com.javarush.test.level22.lesson09.task01;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class SolutionTest extends TestCase {

    static InputStream oldSystemIn = System.in;
    static PrintStream oldSystemOut = System.out;

    public void testMain() throws Exception {
        String fileName = "src/test/resources/level22/lesson09/task01/t1.txt";

        // set new System.in and System.out streams
        System.setIn(new ByteArrayInputStream(fileName.getBytes()));
        ByteArrayOutputStream newSystemOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(newSystemOut));


        Solution solution = new Solution();
        solution.main(null);


        // restore old System.in and System.out streams
        System.setIn(oldSystemIn);
        System.setOut(oldSystemOut);


        Solution.Pair pair1 = new Solution.Pair();
        pair1.first = "sdf";
        pair1.second = "fds";
        Solution.Pair pair2 = new Solution.Pair();
        pair2.first = "123";
        pair2.second = "321";

        Set<String> expected = new HashSet<>();
        expected.add(pair1.toString());
        expected.add(pair2.toString());

        Set<String> actual = new HashSet<>();
        for (Solution.Pair pair : Solution.result) {
            actual.add(pair.toString());
        }

        Assert.assertEquals(expected, actual);

    }
}