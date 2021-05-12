package com.bubnov.cityDirectory.tasks;

import com.bubnov.cityDirectory.City;

public class MaxPopulation {

    public String findMaxPopulation(City[] notSortedCities) {

        System.out.println("\nГород с наибольшим количеством жителей");

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

        System.out.println(String.format("[%d] = %,d", maxIndex, maxPopulation));
        return String.format("[%d] = %,d", maxIndex, maxPopulation);

    }
}
