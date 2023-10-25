package ru.great_larder.sportquiz.database.sqlite.sintax_sqlite;

public interface AuthorSQLite {
    String CREATE(String nameDB);
    String INSERT(String nameDB);
    String UPDATE(String nameDB);
    String SELECT(String nameDB);
}
