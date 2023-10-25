package ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.impl;

import ru.great_larder.sportquiz.database.sqlite.sintax_sqlite.AuthorSQLite;

public class AuthorSQLiteImpl implements AuthorSQLite {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists author (id int " +
            ", lastNameAuthor text" +
            ", firstNameAuthor text" +
            ", aboutMe text" +
            ", link text" +
            ", photo longblob);";
    }
    
    @Override
    public String INSERT(String nameDB) {
        return "INSERT INTO author ( " +
            "    lastNameAuthor," +
            "    firstNameAuthor," +
            "    aboutMe," +
            "    link," +
            "    photo) " +
            " VALUES (?,?,?,?,?)";
    }
    
    @Override
    public String UPDATE(String nameDB) {
        return "UPDATE author SET " +
            "    lastNameAuthor = ?," +
            "    firstNameAuthor = ?," +
            "    aboutMe = ?," +
            "    link = ?," +
            "    photo = ? WHERE id = ? ";
    }
    
    @Override
    public String SELECT(String nameDB) {
        return "SELECT * FROM author";
    }
}
