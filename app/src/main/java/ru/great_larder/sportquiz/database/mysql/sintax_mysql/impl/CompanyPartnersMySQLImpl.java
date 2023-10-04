package ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl;

import ru.great_larder.sportquiz.database.mysql.sintax_mysql.CompanyPartnersMySQL;

public class CompanyPartnersMySQLImpl implements CompanyPartnersMySQL {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists`" + nameDB + "`.`company` (id int" +
            ", name text" +
            ", aboutMe text" +
            ", link text" +
            ", logo longblob) ENGINE = InnoDB";
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
        return "SELECT * FROM `" + nameDB + "`.`company`";
    }
}
