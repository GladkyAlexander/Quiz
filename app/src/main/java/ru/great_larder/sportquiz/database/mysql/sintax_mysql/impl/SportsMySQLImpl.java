package ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl;

import ru.great_larder.sportquiz.database.mysql.sintax_mysql.SportsMySQL;

public class SportsMySQLImpl implements SportsMySQL {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists`" + nameDB + "`.`sports` (id int" +
            ", question text" +
            ", right_answer text" +
            ", wrong_answer_1 text" +
            ", wrong_answer_2 text" +
            ", wrong_answer_3 text" +
            ", link text" +
            ", level text) ENGINE = InnoDB";
    }
    
    @Override
    public String INSERT(String nameDB) {
        return null;
    }
    
    @Override
    public String UPDATE(String nameDB) {
        return null;
    }
    
    @Override
    public String SELECT(String nameDB) {
        return "SELECT * FROM `" + nameDB + "`.`sports`";
    }
}