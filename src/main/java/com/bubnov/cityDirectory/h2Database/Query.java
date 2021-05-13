package com.bubnov.cityDirectory.h2Database;

public class Query {

    public static final String CREATE_TABLE =
            "CREATE TABLE CITIES(\n" +
                    " id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    " name VARCHAR(255),\n" +
                    " district VARCHAR(255),\n" +
                    " region VARCHAR(255),\n" +
                    " population long,\n" +
                    " foundation VARCHAR(255)\n" +
                    "                   );";

    public static final String POST_START_CITIES =
            "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Адыгейск', 'Адыгея', 'Южный', 12248, '1973');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Майкоп', 'Адыгея', 'Южный', 144246, '1857');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Горно-Алтайск', 'Алтай', 'Сибирский', 56928, '1830');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Алдан', 'Якутия', 'Дальневосточный', 21277, '1924');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Александровск-Сахалинский', 'Сахалинская область', 'Дальневосточный', 10613, '1869');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Амурск', 'Хабаровский край', 'Дальневосточный', 42977, '1958');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Абдулино', 'Оренбургская область', 'Приволжский', 20663, '1795');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Агидель', 'Башкортостан', 'Приволжский', 16365, '1980');\n" +
                    "\n" +
                    "INSERT INTO CITIES(NAME, DISTRICT, REGION, POPULATION, FOUNDATION)\n" +
                    "VALUES ('Агрыз', 'Татарстан', 'Приволжский', 19299, '1646');";
}
