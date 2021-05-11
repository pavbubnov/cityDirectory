package com.bubnov.cityDirectory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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


    }

}
