package ru.great_larder.sportquiz.database;

public interface SQLiteFon {
    String CREATE_TABLE_FON = "CREATE TABLE fon(" +
        "    'id'                       INTEGER PRIMARY KEY AUTOINCREMENT, " +
        "    'name'                     TEXT," +
        "    'price'                    INTEGER," +
        "    'image'                    INTEGER," +
        "    'affiliation'              INTEGER);";
    
    String INSERT_TABLE_FON = "INSERT INTO fon ( " +
        "    name," +
        "    price," +
        "    image," +
        "    affiliation) " +
        "VALUES (?,?,?,?,?)";
    
    String UPDATE_FON = "UPDATE 'fon' SET " +
        "    name = ?," +
        "    price = ?," +
        "    image = ?," +
        "    affiliation = ? WHERE id = ? ";
    
    String READ_TABLE_FON = "SELECT * FROM fon";
}
