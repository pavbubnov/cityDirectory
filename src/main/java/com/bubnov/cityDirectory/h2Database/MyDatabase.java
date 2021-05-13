package com.bubnov.cityDirectory.h2Database;

import com.bubnov.cityDirectory.City;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase {

    private static Connection db;

    public static void getH2Connection() {
        if (db == null) {
            try {
                db = DriverManager.getConnection("jdbc:h2:mem:");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Не удалось установить соединение с базой данныйх");
            }
        }
    }

    public static void execute(String query) throws SQLException {

            Statement dataQuery = db.createStatement();
            dataQuery.execute(query);

    }

    public static void postCity(City city) {
        String query = "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                "VALUES" +
                "('" +
                city.getName() +
                "', '" +
                city.getDistrict() +
                "', '" +
                city.getRegion() +
                "', +" +
                city.getPopulation() +
                "," +
                city.getFoundation() +
                ")";
        try {
            execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Не удалось добавить город");
        }
    }


    public static void deleteCity(City city) {
        String query = "DELETE FROM CITIES WHERE NAME = '" +
                city.getName() + "'";
        try {
            execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Не удалось удалить город");
        }
    }

    public static City getCityByName(String name) {
        String query = "SELECT * FROM CITIES WHERE NAME = '" +
                name + "';";
        City city = new City();

        try {
            PreparedStatement preparedStatement = db.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            city = readCityFromRS(rs);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Не удалось найти город с именем" + name);
        }
        return city;
    }

    public static City updateCity(City newVersionCity, String name) {
        String query = "UPDATE CITIES\n" +
                "        SET\n" +
                "        NAME = '" + newVersionCity.getName() + "',\n" +
                "        REGION = '" + newVersionCity.getRegion() + "',\n" +
                "        DISTRICT = '" + newVersionCity.getDistrict() + "',\n" +
                "        POPULATION = " + newVersionCity.getPopulation() + ",\n" +
                "        FOUNDATION = " + newVersionCity.getFoundation() + "\n" +
                "        WHERE NAME = '" + name + "';";

        try {
            execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Не удалось обновить город");
        }
        return getCityByName(newVersionCity.getName());

    }

    public static List<City> selectAll() {

        List<City> cities = new ArrayList<>();

        try (PreparedStatement query =
                     db.prepareStatement("SELECT * FROM CITIES")) {
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                City city = readCityFromRS(rs);
                cities.add(city);
            }
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Не удалось вывести данные");
        }

        return cities;
    }

    private static City readCityFromRS(ResultSet rs) throws SQLException {
        return new City(rs.getString("NAME"), rs.getString("DISTRICT"),
                rs.getString("REGION"), rs.getInt("POPULATION"),
                rs.getString("FOUNDATION"));
    }


}

