package com.javarush.test;


import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.impl.Log4jLoggerAdapter;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {

    }

    public static List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            final String vacancyAttr = "vacancy-serp__vacancy";
            int pageNumber = 0;
            Document doc;
            while ((doc = getDocument(searchString, pageNumber++)) != null) {
                //System.out.println(doc);
                //Elements elements = doc.select("tr["+vacancyAttr+"]");
                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                for (Element element : elements) {
                    System.out.println(element);
                }

                break;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected static Document getDocument(String searchString, int page) throws IOException {
        //Document document = Jsoup.parse(new File("src/main/resources/level28/lesson15/big01/big28data.html"), "UTF-8", "none");
        /*??*/System.setProperty("http.proxyHost", "127.0.0.1");
        /*??*/System.setProperty("http.proxyPort", "9666");

        /*?*/String URL_FORMAT = "http://javarush.ru/testdata/big28data.html?text=java+%s&page=%d";
        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url)
        /*???*/.timeout(20 * 1000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("none")
                    .get();

        return document;
    }


    private static void systemProperties() {
        Properties props = System.getProperties();
        Enumeration keys = props.keys();
        while (keys.hasMoreElements()) {
            String key = (String)keys.nextElement();
            String value = (String)props.get(key);
            System.out.println(key + ": " + value);
        }
    }

    private static void testJsoup() {
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "9666");

        String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
        String url = "http://javarush.ru/testdata/big28data.html";
        //String url = String.format(URL_FORMAT, "Киев", 1);
        try {
            Document doc = Jsoup.connect(url)
                            .timeout(20 * 1000)
                            .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                            .referrer("none")
                            .get();
            String text = doc.html();
            System.out.println(text);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //System.setProperty("http.proxyHost", null);
        //System.setProperty("http.proxyPort", null);
    }

    private static void HttpGet() throws Exception {
        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.delta.internal", 8080));
        //URL url = new URL("http://www.google.com.ua");
        URL url = new URL("http://hh.ua/search/vacancy?text=java+%s&page=%d");
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 9666));

        URLConnection connection = url.openConnection(proxy);
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String fileName = "src/main/resources/level28/lesson15/big01/test2.html";
        BufferedWriter fWriter = new BufferedWriter(new FileWriter(fileName));

        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            fWriter.write(inputLine);
            fWriter.newLine();
        }
        reader.close();
        fWriter.close();
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
