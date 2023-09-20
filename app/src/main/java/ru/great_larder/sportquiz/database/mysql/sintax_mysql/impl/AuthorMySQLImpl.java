package ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl;

import ru.great_larder.sportquiz.database.mysql.sintax_mysql.AuthorMySQL;

public class AuthorMySQLImpl implements AuthorMySQL {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists`" + nameDB + "`.`author` (id int" +
            ", lastNameAuthor text" +
            ", firstNameAuthor text" +
            ", photo longblob) ENGINE = InnoDB";
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
        return "SELECT * FROM `" + nameDB + "`.`author`";
    }
}
