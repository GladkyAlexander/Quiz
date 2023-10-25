package ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.impl;

import ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.CitySQLite;

public class CitySQLiteImpl implements CitySQLite {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists city (id int " +
            ", question text" +
            ", right_answer text" +
            ", wrong_answer_1 text" +
            ", wrong_answer_2 text" +
            ", wrong_answer_3 text" +
            ", link text" +
            ", level text" +
            ", city text" +
            ", linkHistoryOneStreet text" +
            ", label longblob);";
    }
    
    @Override
    public String INSERT(String nameDB) {
        return "INSERT INTO city ( " +
            " question," +
            " right_answer," +
            " wrong_answer_1," +
            " wrong_answer_2," +
            " wrong_answer_3," +
            " link," +
            " level," +
            " city," +
            " linkHistoryOneStreet," +
            " label) " +
            " VALUES (?,?,?,?,?,?,?,?,?,?)";
    }
    
    @Override
    public String UPDATE(String nameDB) {
        return "UPDATE city SET " +
            " question = ?," +
            " right_answer = ?," +
            " wrong_answer_1 = ?," +
            " wrong_answer_2 = ?," +
            " wrong_answer_3 = ?," +
            " link = ?," +
            " level = ?," +
            " city = ?," +
            " linkHistoryOneStreet = ?," +
            " label = ? WHERE id = ? ";
    }
    
    @Override
    public String SELECT(String nameDB) {
        return "SELECT * FROM city";
    }
}
