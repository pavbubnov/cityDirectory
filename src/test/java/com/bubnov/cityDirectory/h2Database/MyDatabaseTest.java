package com.bubnov.cityDirectory.h2Database;

import com.bubnov.cityDirectory.City;
import com.bubnov.cityDirectory.Exception.MyDatabaseException;
import org.junit.Assert;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

public class MyDatabaseTest {

    static final String CREATE_TABLE =
            "CREATE TABLE CITIES(\n" +
                    " id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    " name VARCHAR(255) UNIQUE,\n" +
                    " region VARCHAR(255),\n" +
                    " district VARCHAR(255),\n" +
                    " population long,\n" +
                    " foundation VARCHAR(255)\n" +
                    "                   );";
    static final String POST_START_CITIES =
            "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Адыгейск', 'Адыгея', 'Южный', 12248, '1973')";

    @Test
    public void getH2ConnectionAndExecute() {
        try {
            MyDatabase.getH2Connection();
        } catch (MyDatabaseException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void selectAll() throws SQLException {
        MyDatabase.getH2Connection();
        MyDatabase.execute(CREATE_TABLE);
        MyDatabase.execute(POST_START_CITIES);
        List<String> cities = MyDatabase.selectAll().stream().map(City::getName).collect(Collectors.toList());
        List<String> checkList = new ArrayList<>();
        checkList.add("Адыгейск");
        Assert.assertEquals(checkList, cities);
    }

    @Test
    public void postCity() throws SQLException {
        MyDatabase.getH2Connection();
        City newCity = new City("Город", "Регион", "Область",
                10000, "2021");
        MyDatabase.postCity(newCity);
        MyDatabase.deleteCity(newCity);
    }

    @Test(expected = MyDatabaseException.class)
    public void deleteCity() {
        MyDatabase.getH2Connection();
        City city = new City("Адыгейск", "Адыгея", "Южный", 12248, "1973");
        MyDatabase.deleteCity(city);
        MyDatabase.getCityByName("Адыгейск");
    }

    @Test
    public void getCityByName() throws SQLException {
        MyDatabase.getH2Connection();
        int population = MyDatabase.getCityByName("Адыгейск").getPopulation();
        Assert.assertEquals(population, 12248);
    }

    @Test(expected = MyDatabaseException.class)
    public void getCityByNameFail() throws SQLException {
        MyDatabase.getH2Connection();
        MyDatabase.getCityByName("Адыг");
    }

    @Test
    public void updateCity() throws SQLException {
        MyDatabase.getH2Connection();
        City newCity = new City("Новый Город", "Новый регион", "Новая область",
                10000, "2021");
        MyDatabase.updateCity(newCity, "Адыгейск");
        City cityFromDB = MyDatabase.getCityByName("Новый Город");
        Assert.assertEquals(cityFromDB, newCity);
        City oldCity = new City("Адыгейск", "Адыгея", "Южный", 12248, "1973");
        MyDatabase.updateCity(oldCity, "Новый Город");
    }
}