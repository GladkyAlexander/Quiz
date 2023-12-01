package ru.great_larder.sportquiz.database.syntax_db;

public interface SyntaxHistory {
    String CREATE(String nameDB);
    String INSERT(String nameDB);
    String UPDATE(String nameDB);
    String SELECT(String nameDB);
}
