package com.bubnov.cityDirectory.tasks;

import com.bubnov.cityDirectory.City;

import java.util.*;

public class Task {

    private List<City> inputCities;

    public Task(List<City> inputCities) {
        this.inputCities = inputCities;
    }

    public List<City> sortByName() {
        List<City> cities = new ArrayList<>(inputCities);
        cities.sort(
                new Comparator<City>() {
                    @Override
                    public int compare(City o1, City o2) {
                        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
                    }
                }
        );
        return cities;
    }

    public List<City> sortByDistrictAndName() {
        List<City> cities = new ArrayList<>(inputCities);
        cities.sort(Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName));
        return cities;
    }

    public City[] createArray() {
        City[] arrayCities = new City[inputCities.size()];
        arrayCities = inputCities.toArray(arrayCities);
        return arrayCities;
    }

    public String findMaxPopulation() {
        City[] notSortedCities = createArray();
        int maxPopulation = 0;
        int index = 0;
        int maxIndex = 0;
        for (City city : notSortedCities) {
            index++;
            if (city.getPopulation() > maxPopulation) {
                maxPopulation = city.getPopulation();
                maxIndex = index;
            }
        }
        return String.format("[%d] = %,d", maxIndex, maxPopulation);
    }

    public List<String> countCityByRegions() {
        Map<String, Integer> hashMap = new HashMap<>();
        for (City city : inputCities) {
            Integer i = hashMap.get(city.getRegion());
            if (i == null) {
                hashMap.put(city.getRegion(), 1);
            } else {
                hashMap.put(city.getRegion(), i + 1);
            }
        }
        Set<String> regions = hashMap.keySet();
        List<String> cityRegionInformation = new ArrayList<>();
        for (String region : regions) {
            cityRegionInformation.add(region + " - " + hashMap.get(region));
        }
        return cityRegionInformation;
    }
}
