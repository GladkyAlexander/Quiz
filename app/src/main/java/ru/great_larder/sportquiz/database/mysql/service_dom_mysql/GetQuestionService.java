package ru.great_larder.sportquiz.database.mysql.service_dom_mysql;

import ru.great_larder.sportquiz.domain.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GetQuestionService {
    Question getQuestion(ResultSet resultSet) throws SQLException;
}
