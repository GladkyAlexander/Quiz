package ru.great_larder.sportquiz.database.mysql.sintax_mysql;

public interface CityMySQL {
    String CREATE(String nameDB);
    String INSERT(String nameDB);
    String UPDATE(String nameDB);
    String SELECT(String nameDB);
}
