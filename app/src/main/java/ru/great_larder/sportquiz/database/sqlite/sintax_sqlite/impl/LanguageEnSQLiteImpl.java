package ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.impl;

import ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.LanguageEnSQLite;

public class LanguageEnSQLiteImpl implements LanguageEnSQLite {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists language_en (id int " +
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
        return "INSERT INTO language_en ( " +
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
        return "UPDATE language_en SET " +
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
        return "SELECT * FROM language_en";
    }
}
