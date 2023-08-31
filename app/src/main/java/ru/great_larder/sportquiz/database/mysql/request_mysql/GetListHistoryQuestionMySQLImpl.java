package ru.great_larder.sportquiz.database.mysql.request_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionService;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionServiceImpl;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.HistoryMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.HistoryMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListHistoryQuestionMySQLImpl implements GetListQuestionMySQL {
    @Override
    public List<Question> getListQuestion(User user, Context context) {
        List<Question> questions = new ArrayList<>();
        
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableHistoryMySQL();
        HistoryMySQL historyMySQL = new HistoryMySQLImpl();
        GetQuestionService getQuestionService = new GetQuestionServiceImpl();
        try {
            connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(historyMySQL.SELECT(connectMySQL.nameDB));
            
            while (connectMySQL.resultSetMySQL.next()){
                questions.add(getQuestionService.getQuestion(connectMySQL.resultSetMySQL));
            }
            
            connectMySQL.closeMySQLDatabase();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        
        return questions;
    }
}
