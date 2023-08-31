package ru.great_larder.sportquiz.database;

public interface SQLiteFairies {
    String CREATE_TABLE_FAIRIES = "CREATE TABLE IF NOT EXISTS fairies (" +
        "    'id'                       INTEGER," +
        "    'idUser'                   INTEGER," +
        "    'name'                        TEXT," +
        "    'price'                    INTEGER," +
        "    'imageI'                   INTEGER," +
        "    'dateStart'                   DATE," +
        "    'validity_period'          INTEGER," +
        "    'activity_fairies'         INTEGER);";
    
    String INSERT_TABLE_FAIRIES = "INSERT INTO fairies ( " +
        "    id," +
        "    idUser," +
        "    name," +
        "    price," +
        "    imageI," +
        "    dateStart," +
        "    validity_period," +
        "    activity_fairies) " +
        " VALUES (?,?,?,?,?,?,?,?)";
    
    String UPDATE_FAIRIES = "UPDATE 'fairies' SET " +
        "    id = ?," +
        "    idUser = ?," +
        "    name = ?," +
        "    price = ?," +
        "    imageI = ?," +
        "    dateStart = ?," +
        "    validity_period = ?," +
        "    activity_fairies = ? WHERE id = ? ";
    
    String READ_TABLE_FAIRIES = "SELECT * FROM fairies";
}
