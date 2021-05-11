package com.bubnov.cityDirectory;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("cities.txt");
        Scanner scanner;

        List<City> cities = new ArrayList<>();


        scanner = new Scanner(file);

        System.out.println("\nНеотсортированный список");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String[] splitLine = line.split(";");

            City city = new City(splitLine[1], splitLine[2], splitLine[3], Integer.valueOf(splitLine[4]), splitLine[5]);
            cities.add(city);

            System.out.println(city.toString());

        }

        City[] notSortedCities = new City[cities.size()];
        notSortedCities = cities.toArray(notSortedCities);

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

//        cities.sort(
//                new Comparator<City>() {
//                    @Override
//                    public int compare(City o2, City o1) {
//                        return o2.getDistrict().toLowerCase().compareTo(o1.getDistrict().toLowerCase());
//                    }
//                }.thenComparing(new Comparator<City>() {
//                    @Override
//                    public int compare(City o2, City o1) {
//                        return o2.getName().toLowerCase().compareTo(o1.getName().toLowerCase());
//                    }
//                })
//        );

        cities.sort(Comparator.comparing(City :: getDistrict)
                .thenComparing(City::getName));

        System.out.println("\nСписок, отсортированный по наименованию Федерального округв и наименованию города");
        for (City city : cities) {
            System.out.println(city);
        }


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

        System.out.printf("[%d] = %,d", maxIndex, maxPopulation );

        System.out.println("\nГорода в разрезе регионов:");

        Map<String, Integer> hashMap = new HashMap<>();
        for (City city : notSortedCities ) {
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
