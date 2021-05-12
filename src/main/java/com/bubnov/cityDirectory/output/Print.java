package com.bubnov.cityDirectory.output;

import com.bubnov.cityDirectory.City;

import java.util.List;

public class Print {

    public void printCityList(List<City> cities) {
        for (City city : cities) {
            System.out.println(city);
        }
    }

    public void printString(String s) {
        System.out.println(s);
    }

    public void printStringList(List<String> information) {
        for (String info : information) {
            System.out.println(info);
        }
    }
}
