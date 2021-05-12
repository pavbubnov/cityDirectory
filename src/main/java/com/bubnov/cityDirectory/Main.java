package com.bubnov.cityDirectory;

import com.bubnov.cityDirectory.tasks.MaxPopulation;
import com.bubnov.cityDirectory.tasks.ReadFile;
import com.bubnov.cityDirectory.tasks.RegionCount;
import com.bubnov.cityDirectory.tasks.Sorting;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        ReadFile readFile = new ReadFile();
        List<City> cities = readFile.readFromFile("cities.txt");
        Sorting sorting = new Sorting();
        City[] notSortedCities = sorting.createArray(cities);

        sorting.sortByName(cities);
        sorting.sortByDistrictAndName(cities);

        MaxPopulation maxPopulation = new MaxPopulation();
        maxPopulation.findMaxPopulation(notSortedCities);

        RegionCount regionCount = new RegionCount();
        regionCount.countCityByRegions(cities);


    }

}
