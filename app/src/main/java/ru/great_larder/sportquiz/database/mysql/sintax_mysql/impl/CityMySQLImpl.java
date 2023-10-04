package ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl;

import ru.great_larder.sportquiz.database.mysql.sintax_mysql.CityMySQL;

public class CityMySQLImpl implements CityMySQL {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists`" + nameDB + "`.`city` (id int AUTO_INCREMENT primary key NOT NULL" +
            ", question text" +
            ", right_answer text" +
            ", wrong_answer_1 text" +
            ", wrong_answer_2 text" +
            ", wrong_answer_3 text" +
            ", link text" +
            ", level text" +
            ", city text" +
            ", label longblob) ENGINE = InnoDB";
    }
    
    @Override
    public String INSERT(String nameDB) {
        return "INSERT INTO `" + nameDB + "`.`city` (" +
            " question," +
            " right_answer," +
            " wrong_answer_1," +
            " wrong_answer_2," +
            " wrong_answer_3," +
            " link," +
            " level," +
            " city," +
            " label) VALUES (?,?,?,?,?,?,?,?,?)";
    }
    
    @Override
    public String UPDATE(String nameDB) {
        return null;
    }
    
    @Override
    public String SELECT(String nameDB) {
        return "SELECT * FROM `" + nameDB + "`.`city`";
    }
}