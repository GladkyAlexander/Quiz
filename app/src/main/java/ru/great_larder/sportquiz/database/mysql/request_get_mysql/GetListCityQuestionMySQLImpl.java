package ru.great_larder.sportquiz.database.mysql.request_get_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionCityMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.CityMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.CityMySQLImpl;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListCityQuestionMySQLImpl implements GetListQuestionCityMySQL {
    @Override
    public List<QuestionCity> getListQuestion(User user, Context context) {
        List<QuestionCity> questions = new ArrayList<>();
        
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableCityMySQL();
        CityMySQL cityMySQL = new CityMySQLImpl();
        try {
            connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(cityMySQL.SELECT(connectMySQL.nameDB));
            
            while (connectMySQL.resultSetMySQL.next()){
                
                QuestionCity question = new QuestionCity();
                question.setId(connectMySQL.resultSetMySQL.getInt("id"));
                question.setQuestion(connectMySQL.resultSetMySQL.getString("question"));
                question.setRightAnswer(connectMySQL.resultSetMySQL.getString("right_answer"));
                question.setWrongAnswer1(connectMySQL.resultSetMySQL.getString("wrong_answer_1"));
                question.setWrongAnswer2(connectMySQL.resultSetMySQL.getString("wrong_answer_2"));
                question.setWrongAnswer3(connectMySQL.resultSetMySQL.getString("wrong_answer_3"));
                question.setLink(connectMySQL.resultSetMySQL.getString("link"));
                question.setLevel(Integer.parseInt(connectMySQL.resultSetMySQL.getString("level")));
                question.setCity(connectMySQL.resultSetMySQL.getString("city"));
                question.setLinkHistoryOneStreet(connectMySQL.resultSetMySQL.getNString("linkHistoryOneStreet"));
                Blob blob = connectMySQL.resultSetMySQL.getBlob("label");
                int blobLength = (int) blob.length();
                
                question.setLabel(blob.getBytes(1, blobLength));
                
                questions.add(question);
            }
            connectMySQL.closeMySQLDatabase();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        
        return questions;
    }
}
