package ru.great_larder.sportquiz.database.mysql.request_get_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionService;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionServiceImpl;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxCity;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.CityMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListCityQuestionMySQLImpl implements GetListQuestionMySQL {
    @Override
    public List<Question> getListQuestion(User user, Context context) {
        List<Question> questions = new ArrayList<>();
        
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableCityMySQL();
        SyntaxCity cityMySQL = new CityMySQLImpl();
        GetQuestionService getQuestionService = new GetQuestionServiceImpl();
        try {
            connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(cityMySQL.SELECT(connectMySQL.nameDB));
            
            while (connectMySQL.resultSetMySQL.next()){
                
                QuestionCity question = new QuestionCity();
	            getQuestionService.getQuestion(connectMySQL, question);
                
                question.setCity(connectMySQL.resultSetMySQL.getString("city"));
                question.setLinkHistoryOneStreet(connectMySQL.resultSetMySQL.getString("linkHistoryOneStreet"));
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
