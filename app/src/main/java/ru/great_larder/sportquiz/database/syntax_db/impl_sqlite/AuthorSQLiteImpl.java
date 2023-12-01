package ru.great_larder.sportquiz.database.syntax_db.impl_sqlite;

import ru.great_larder.sportquiz.database.syntax_db.SyntaxAuthor;

public class AuthorSQLiteImpl implements SyntaxAuthor {
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
