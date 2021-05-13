package com.bubnov.cityDirectory.h2Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabase {

    public static Connection getH2Connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:");
    }

    public static void execute(Connection db, String query) throws SQLException {
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(query);
        }
    }

    public static void postCity(Connection db, String name, String district, String region, int population, String foundation) throws SQLException {
        String query = "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                "VALUES" +
                "('" +
                name +
                "', '" +
                district +
                "', '" +
                region +
                "', +" +
                population +
                "," +
                foundation +
                ")";
        execute(db, query);
    }

    public static void selectAll(Connection db) throws SQLException {

        try (PreparedStatement query =
                     db.prepareStatement("SELECT * FROM CITIES")) {
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s, %s, %s, %s, %s",
                        rs.getString("NAME"), rs.getString("DISTRICT"),
                        rs.getString("REGION"), rs.getString("POPULATION"),
                        rs.getString("FOUNDATION")));
            }
            rs.close();
        }
    }


}

