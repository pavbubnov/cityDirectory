package com.bubnov.cityDirectory.tasks;

import com.bubnov.cityDirectory.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public List<City> readFromFile(String pathName) throws FileNotFoundException {

        File file = new File(pathName);
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

        return cities;
    }

}
