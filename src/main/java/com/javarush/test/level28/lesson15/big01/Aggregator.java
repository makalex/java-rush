package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.LinkedInStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;
import com.javarush.test.level28.lesson15.big01.view.View;


public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Provider providerHH = new Provider(new HHStrategy());
        Provider providerLinkedIn = new Provider(new LinkedInStrategy());
        Model model = new Model(view, new Provider[] {providerHH, providerLinkedIn});
        view.setController(new Controller(model));
        view.userCitySelectEmulationMethod();
    }
}
