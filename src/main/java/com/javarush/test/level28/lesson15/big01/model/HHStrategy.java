package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";


    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int pageNumber = 0;
            Document doc;
            while (true) {
                doc = getDocument(searchString, pageNumber++);
                if (doc == null) break;

                Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0) break;

                for (Element element : elements) {
                    Element titleElement = element.select("[data-qa=vacancy-serp__vacancy-title]").first();
                    String title = titleElement.text();
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null) {
                        salary = salaryElement.text();
                    }
                    String city = element.select("[data-qa=vacancy-serp__vacancy-address]").first().text();
                    String companyName = element.select("[data-qa=vacancy-serp__vacancy-employer]").first().text();
                    String siteName = "http://hh.ua/";
                    String url = titleElement.attr("href");

                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(title);
                    vacancy.setSalary(salary);
                    vacancy.setCity(city);
                    vacancy.setCompanyName(companyName);
                    vacancy.setSiteName(siteName);
                    vacancy.setUrl(url);
                    vacancies.add(vacancy);

                    //System.out.println("Title = " + title);
                    //System.out.println("Salary = " + salary);
                    //System.out.println("City = " + city);
                    //System.out.println("CompanyName = " + companyName);
                    //System.out.println("SiteName = " + siteName);
                    //System.out.println("URL = " + url);
                    //System.out.println();
                    //System.out.println();
                }

                //break;
            }
        }
        catch (Exception e) {
            //e.printStackTrace();
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        /*??*/ //System.setProperty("http.proxyHost", "127.0.0.1");
        /*??*/ //System.setProperty("http.proxyPort", "9666");

        /*???*/// String URL_FORMAT = "http://javarush.ru/testdata/big28data.html?text=java+%s&page=%d";

        String url = String.format(URL_FORMAT, searchString, page);
        Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("none")
                .get();

        return document;
    }
}
