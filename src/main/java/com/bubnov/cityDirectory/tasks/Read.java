package com.bubnov.cityDirectory.tasks;

import com.bubnov.cityDirectory.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Read {

    public List<City> readFromFile(String pathName) throws FileNotFoundException, ArrayIndexOutOfBoundsException {
        File file = new File(pathName);
        Scanner scanner;
        List<City> cities = new ArrayList<>();
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(";");
            City city = new City(splitLine[1].trim(), splitLine[2].trim(), splitLine[3].trim(),
                    Integer.valueOf(splitLine[4].trim()), splitLine[5].trim());
            cities.add(city);
        }
        return cities;
    }

}
