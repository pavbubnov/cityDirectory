package com.bubnov.cityDirectory;

import com.bubnov.cityDirectory.h2Database.MyDatabase;
import com.bubnov.cityDirectory.h2Database.Query;
import com.bubnov.cityDirectory.output.Print;
import com.bubnov.cityDirectory.tasks.Read;
import com.bubnov.cityDirectory.tasks.Task;

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
        MyDatabase.getH2Connection();
        try {
            MyDatabase.execute(Query.CREATE_TABLE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            MyDatabase.execute(Query.POST_START_CITIES);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("\nВывод всех городов");
        MyDatabase.selectAll().forEach(System.out::println);
        City newCity = new City("Новый Город", "Новый регион", "Новая область",
                10000, "2021");
        MyDatabase.postCity(newCity);
        System.out.println("\nВывод всех городов после создания");
        MyDatabase.selectAll().forEach(System.out::println);
        MyDatabase.deleteCity(newCity);
        System.out.println("\nВывод всех городов после удаления");
        MyDatabase.selectAll().forEach(System.out::println);
        System.out.println("\nВывод города по имени Амурск");
        System.out.println(MyDatabase.getCityByName("Амурск"));
        System.out.println("\nВывод обновленного города");
        MyDatabase.updateCity(newCity, "Алдан");
        MyDatabase.selectAll().forEach(System.out::println);
    }
}
