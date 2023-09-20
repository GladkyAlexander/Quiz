package ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl;

import ru.great_larder.sportquiz.database.mysql.sintax_mysql.TrafficLawsMySQL;

public class TrafficLawsMySQLImpl implements TrafficLawsMySQL {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists`" + nameDB + "`.`traffic_laws` (id int AUTO_INCREMENT primary key NOT NULL" +
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
        return "INSERT INTO `" + nameDB + "`.`traffic_laws` (" +
            " question," +
            " right_answer," +
            " wrong_answer_1," +
            " wrong_answer_2," +
            " wrong_answer_3," +
            " link," +
            " level) VALUES (?,?,?,?,?,?,?)";
    }
    
    @Override
    public String UPDATE(String nameDB) {
        return null;
    }
    
    @Override
    public String SELECT(String nameDB) {
        return "SELECT * FROM `" + nameDB + "`.`traffic_laws`";
    }
}
