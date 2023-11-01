package ru.great_larder.sportquiz.database.mysql.service_dom_mysql;

import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.domain.Question;

import java.sql.SQLException;

public class GetQuestionServiceImpl implements GetQuestionService {
    @Override
    public Question getQuestion(ConnectMySQL connectMySQL, Question question) throws SQLException {
        
        question.setId(connectMySQL.resultSetMySQL.getInt("id"));
        question.setQuestion(connectMySQL.resultSetMySQL.getString("question"));
        question.setRightAnswer(connectMySQL.resultSetMySQL.getString("right_answer"));
        question.setWrongAnswer1(connectMySQL.resultSetMySQL.getString("wrong_answer_1"));
        question.setWrongAnswer2(connectMySQL.resultSetMySQL.getString("wrong_answer_2"));
        question.setWrongAnswer3(connectMySQL.resultSetMySQL.getString("wrong_answer_3"));
        question.setLink(connectMySQL.resultSetMySQL.getString("link"));
        question.setLevel(Integer.parseInt(connectMySQL.resultSetMySQL.getString("level")));
        
        return question;
    }
}
