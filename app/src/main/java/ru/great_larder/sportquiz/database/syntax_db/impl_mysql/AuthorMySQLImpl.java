package ru.great_larder.sportquiz.database.syntax_db.impl_mysql;

import ru.great_larder.sportquiz.database.syntax_db.SyntaxAuthor;

public class AuthorMySQLImpl implements SyntaxAuthor {
    @Override
    public String CREATE(String nameDB) {
        return "CREATE TABLE if not exists`" + nameDB + "`.`author` (id int AUTO_INCREMENT primary key NOT NULL" +
            ", lastNameAuthor text" +
            ", firstNameAuthor text" +
            ", aboutMe text" +
            ", link text" +
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
