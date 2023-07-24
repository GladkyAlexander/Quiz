package ru.great_larder.sportquiz.database;

public interface SQLitePuzzle {
    String CREATE_TABLE_PUZZLE = "CREATE TABLE puzzle (" +
        "    'id'                       INTEGER, " +
        "    'id_drawable_resource'     INTEGER," +
        "    'id_user'                  INTEGER," +
        "    'price1'                   INTEGER," +
        "    'puzzle1'                  INTEGER," +
        "    'price2'                   INTEGER," +
        "    'puzzle2'                  INTEGER," +
        "    'price3'                   INTEGER," +
        "    'puzzle3'                  INTEGER," +
        "    'price4'                   INTEGER," +
        "    'puzzle4'                  INTEGER," +
        "    'price5'                   INTEGER," +
        "    'puzzle5'                  INTEGER," +
        "    'price6'                   INTEGER," +
        "    'puzzle6'                  INTEGER," +
        "    'price7'                   INTEGER," +
        "    'puzzle7'                  INTEGER," +
        "    'price8'                   INTEGER," +
        "    'puzzle8'                  INTEGER," +
        "    'price9'                   INTEGER," +
        "    'puzzle9'                  INTEGER," +
        "    'price10'                  INTEGER," +
        "    'puzzle10'                 INTEGER," +
        "    'price11'                   INTEGER," +
        "    'puzzle11'                  INTEGER," +
        "    'price12'                   INTEGER," +
        "    'puzzle12'                  INTEGER," +
        "    'price13'                   INTEGER," +
        "    'puzzle13'                  INTEGER," +
        "    'price14'                   INTEGER," +
        "    'puzzle14'                  INTEGER," +
        "    'price15'                   INTEGER," +
        "    'puzzle15'                  INTEGER," +
        "    'price16'                   INTEGER," +
        "    'puzzle16'                  INTEGER," +
        "    'price17'                   INTEGER," +
        "    'puzzle17'                  INTEGER," +
        "    'price18'                   INTEGER," +
        "    'puzzle18'                  INTEGER," +
        "    'price19'                   INTEGER," +
        "    'puzzle19'                  INTEGER," +
        "    'price20'                   INTEGER," +
        "    'puzzle20'                  INTEGER," +
        "    'price21'                   INTEGER," +
        "    'puzzle21'                  INTEGER," +
        "    'price22'                   INTEGER," +
        "    'puzzle22'                  INTEGER," +
        "    'price23'                   INTEGER," +
        "    'puzzle23'                  INTEGER," +
        "    'price24'                   INTEGER," +
        "    'puzzle24'                  INTEGER," +
        "    'price25'                   INTEGER," +
        "    'puzzle25'                  INTEGER," +
        "    'price26'                   INTEGER," +
        "    'puzzle26'                  INTEGER," +
        "    'price27'                   INTEGER," +
        "    'puzzle27'                  INTEGER," +
        "    'price28'                   INTEGER," +
        "    'puzzle28'                  INTEGER," +
        "    'price29'                   INTEGER," +
        "    'puzzle29'                  INTEGER," +
        "    'price30'                   INTEGER," +
        "    'puzzle30'                 INTEGER);";
    
    String INSERT_TABLE_PUZZLE = "INSERT INTO puzzle ( " +
        "    id, " +
        "    id_drawable_resource," +
        "    id_user," +
        "    price1," +
        "    puzzle1," +
        "    price2," +
        "    puzzle2," +
        "    price3," +
        "    puzzle3," +
        "    price4," +
        "    puzzle4," +
        "    price5," +
        "    puzzle5," +
        "    price6," +
        "    puzzle6," +
        "    price7," +
        "    puzzle7," +
        "    price8," +
        "    puzzle8," +
        "    price9," +
        "    puzzle9," +
        "    price10," +
        "    puzzle10," +
        "    price11," +
        "    puzzle11," +
        "    price12," +
        "    puzzle12," +
        "    price13," +
        "    puzzle13," +
        "    price14," +
        "    puzzle14," +
        "    price15," +
        "    puzzle15," +
        "    price16," +
        "    puzzle16," +
        "    price17," +
        "    puzzle17," +
        "    price18," +
        "    puzzle18," +
        "    price19," +
        "    puzzle19," +
        "    price20," +
        "    puzzle20," +
        "    price21," +
        "    puzzle21," +
        "    price22," +
        "    puzzle22," +
        "    price23," +
        "    puzzle23," +
        "    price24," +
        "    puzzle24," +
        "    price25," +
        "    puzzle25," +
        "    price26," +
        "    puzzle26," +
        "    price27," +
        "    puzzle27," +
        "    price28," +
        "    puzzle28," +
        "    price29," +
        "    puzzle29," +
        "    price30," +
        "    puzzle30) " +
        " VALUES (?,?,?" +
        ",?,?,?,?,?,?,?,?,?,?" +
        ",?,?,?,?,?,?,?,?,?,?" +
        ",?,?,?,?,?,?,?,?,?,?)";
    
    String UPDATE_PUZZLE = "UPDATE 'puzzle' SET " +
        "    id = ?, " +
        "    id_drawable_resource = ?," +
        "    id_user = ?," +
        "    price1 = ?," +
        "    puzzle1 = ?," +
        "    price2 = ?," +
        "    puzzle2 = ?," +
        "    price3 = ?," +
        "    puzzle3 = ?," +
        "    price4 = ?," +
        "    puzzle4 = ?," +
        "    price5 = ?," +
        "    puzzle5 = ?," +
        "    price6 = ?," +
        "    puzzle6 = ?," +
        "    price7 = ?," +
        "    puzzle7 = ?," +
        "    price8 = ?," +
        "    puzzle8 = ?," +
        "    price9 = ?," +
        "    puzzle9 = ?," +
        "    price10 = ?," +
        "    puzzle10 = ?," +
        "    price11 = ?," +
        "    puzzle11 = ?," +
        "    price12 = ?," +
        "    puzzle12 = ?," +
        "    price13 = ?," +
        "    puzzle13 = ?," +
        "    price14 = ?," +
        "    puzzle14 = ?," +
        "    price15 = ?," +
        "    puzzle15 = ?," +
        "    price16 = ?," +
        "    puzzle16 = ?," +
        "    price17 = ?," +
        "    puzzle17 = ?," +
        "    price18 = ?," +
        "    puzzle18 = ?," +
        "    price19 = ?," +
        "    puzzle19 = ?," +
        "    price20 = ?," +
        "    puzzle20 = ?," +
        "    price21 = ?," +
        "    puzzle21 = ?," +
        "    price22 = ?," +
        "    puzzle22 = ?," +
        "    price23 = ?," +
        "    puzzle23 = ?," +
        "    price24 = ?," +
        "    puzzle24 = ?," +
        "    price25 = ?," +
        "    puzzle25 = ?," +
        "    price26 = ?," +
        "    puzzle26 = ?," +
        "    price27 = ?," +
        "    puzzle27 = ?," +
        "    price28 = ?," +
        "    puzzle28 = ?," +
        "    price29 = ?," +
        "    puzzle29 = ?," +
        "    price30 = ?," +
        "    puzzle30 = ? WHERE id = ? ";
    
    String READ_TABLE_PUZZLE = "SELECT * FROM puzzle";
}
