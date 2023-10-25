package ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.impl;

import ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.CompanyPartnersSQLite;

public class CompanyPartnersSQLiteImpl implements CompanyPartnersSQLite {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists company (id int " +
            ", name text" +
            ", aboutMe text" +
            ", link text" +
            ", logo longblob);";
    }
    
    @Override
    public String INSERT(String nameDB) {
        return "INSERT INTO author ( " +
            "    name," +
            "    aboutMe," +
            "    link," +
            "    logo) " +
            " VALUES (?,?,?,?)";
    }
    
    @Override
    public String UPDATE(String nameDB) {
        return "UPDATE author SET " +
            "    name = ?," +
            "    aboutMe = ?," +
            "    link = ?," +
            "    logo = ? WHERE id = ? ";
    }
    
    @Override
    public String SELECT(String nameDB) {
        return "SELECT * FROM company ";
    }
}
