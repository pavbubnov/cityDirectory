package com.bubnov.cityDirectory;

import com.bubnov.cityDirectory.h2Database.MyDatabase;
import com.bubnov.cityDirectory.h2Database.Query;
import com.bubnov.cityDirectory.output.Print;
import com.bubnov.cityDirectory.tasks.Read;
import com.bubnov.cityDirectory.tasks.Task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Read read = new Read();
        try {
            List<City> notSortedCitiesList = read.readFromFile("cities.txt");
            start(notSortedCitiesList);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Проверьте корректность файла");
        }

        startDatabase();

    }

    public static void start(List<City> notSortedCitiesList) {
        Print print = new Print();
        Task task = new Task(notSortedCitiesList);
        System.out.println("\nСписок без сортировки");
        print.printCityList(notSortedCitiesList);
        List<City> sortedByName = task.sortByName();
        System.out.println("\nСписок, отсортированный по именам");
        print.printCityList(sortedByName);
        List<City> sortByDistrictAndName = task.sortByDistrictAndName();
        System.out.println("\nСписок, отсортированный по наименованию Федерального округа и наименованию города");
        print.printCityList(sortByDistrictAndName);
        String maxPopulationInfo = task.findMaxPopulation();
        System.out.println("\nГород с наибольшим количеством жителей");
        print.printString(maxPopulationInfo);
        List<String> cityRegionInformation = task.countCityByRegions();
        System.out.println("\nГорода в разрезе регионов:");
        print.printStringList(cityRegionInformation);
    }

    public static void startDatabase() {

        try {
            Connection connection = MyDatabase.getH2Connection();
            MyDatabase.execute(connection, Query.CREATE_TABLE);
            MyDatabase.execute(connection, Query.POST_START_CITIES);
            System.out.println("\nВывод всех городов");
            MyDatabase.selectAll(connection);
            MyDatabase.postCity(connection, "Новый Город", "Новая область", "Новый регион",
                    10000, "2021");
            System.out.println("\nВывод всех городов после создания");
            MyDatabase.selectAll(connection);

        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }


}
