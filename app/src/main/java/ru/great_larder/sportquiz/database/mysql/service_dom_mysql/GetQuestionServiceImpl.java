package ru.great_larder.sportquiz.database.mysql.service_dom_mysql;

import ru.great_larder.sportquiz.domain.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetQuestionServiceImpl implements GetQuestionService {
    @Override
    public Question getQuestion(ResultSet resultSet) throws SQLException {
        
        Question question = new Question();
        question.setQuestion(resultSet.getString("question"));
        question.setRightAnswer(resultSet.getString("right_answer"));
        question.setWrongAnswer1(resultSet.getString("wrong_answer_1"));
        question.setWrongAnswer2(resultSet.getString("wrong_answer_2"));
        question.setWrongAnswer3(resultSet.getString("wrong_answer_3"));
        question.setLink(resultSet.getString("link"));
        question.setLevel(Integer.parseInt(resultSet.getString("level")));
        
        return question;
    }
}
