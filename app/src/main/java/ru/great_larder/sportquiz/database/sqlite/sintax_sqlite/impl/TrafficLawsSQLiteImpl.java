package ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.impl;

import ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.TrafficLawsSQLite;

public class TrafficLawsSQLiteImpl implements TrafficLawsSQLite {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists traffic_laws (id int " +
            ", question text" +
            ", right_answer text" +
            ", wrong_answer_1 text" +
            ", wrong_answer_2 text" +
            ", wrong_answer_3 text" +
            ", link text" +
            ", level text);";
    }
    
    @Override
    public String INSERT(String nameDB) {
        return "INSERT INTO traffic_laws ( " +
            " question," +
            " right_answer," +
            " wrong_answer_1," +
            " wrong_answer_2," +
            " wrong_answer_3," +
            " link," +
            " level) " +
            " VALUES (?,?,?,?,?,?,?)";
    }
    
    @Override
    public String UPDATE(String nameDB) {
        return "UPDATE traffic_laws SET " +
            " question = ?," +
            " right_answer = ?," +
            " wrong_answer_1 = ?," +
            " wrong_answer_2 = ?," +
            " wrong_answer_3 = ?," +
            " link = ?," +
            " level = ? WHERE id = ? ";
    }
    
    @Override
    public String SELECT(String nameDB) {
        return "SELECT * FROM traffic_laws";
    }
}
