package ru.great_larder.sportquiz.database;

public interface SQLiteUser {
    String CREATE_TABLE_USER = "CREATE TABLE user (" +
            "    'id'                       INTEGER  PRIMARY KEY AUTOINCREMENT, " +
            "    'name'                     TEXT," +
            "    'city'                     TEXT," +
            "    'glasses'                  INTEGER," +
            "    'themeInstalledNow'        INTEGER);";

    String INSERT_TABLE_USER = "INSERT INTO user ( " +
            "    name," +
            "    city," +
            "    glasses," +
            "    themeInstalledNow) " +
            " VALUES (?,?,?,?)";

    String UPDATE_USER = "UPDATE 'user' SET " +
            "    name = ?," +
            "    city = ?," +
            "    glasses = ?," +
            "    themeInstalledNow = ? WHERE id = ? ";

    String READ_TABLE_USER = "SELECT * FROM user";
}
