package com.bubnov.cityDirectory.tasks;

import com.bubnov.cityDirectory.City;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RegionCount {

    public void countCityByRegions(List<City> notSortedCities) {

        System.out.println("\nГорода в разрезе регионов:");

        Map<String, Integer> hashMap = new HashMap<>();
        for (City city : notSortedCities) {
            Integer i = hashMap.get(city.getRegion());
            if (i == null) {
                hashMap.put(city.getRegion(), 1);
            } else {
                hashMap.put(city.getRegion(), i + 1);
            }
        }
        Set<String> regions = hashMap.keySet();

        for (String region : regions) {
            System.out.println(region + " - " + hashMap.get(region));
        }


    }

}
