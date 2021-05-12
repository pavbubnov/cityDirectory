package com.bubnov.cityDirectory.tasks;

import com.bubnov.cityDirectory.City;

import java.util.Comparator;
import java.util.List;

public class Sorting {

    public List<City> sortByName(List<City> cities) {

        cities.sort(
                new Comparator<City>() {
                    @Override
                    public int compare(City o1, City o2) {
                        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                    }
                }
        );

        System.out.println("\nСписок, отсортированный по городам");
        for (City city : cities) {
            System.out.println(city);
        }

        return cities;
    }


    public List<City>  sortByDistrictAndName(List<City> cities) {

        cities.sort(Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName));

        System.out.println("\nСписок, отсортированный по наименованию Федерального округа и наименованию города");
        for (City city : cities) {
            System.out.println(city);
        }

        return cities;
    }

    public City[] createArray(List<City> cities) {
        City[] arrayCities = new City[cities.size()];
        arrayCities = cities.toArray(arrayCities);
        return arrayCities;
    }


}
