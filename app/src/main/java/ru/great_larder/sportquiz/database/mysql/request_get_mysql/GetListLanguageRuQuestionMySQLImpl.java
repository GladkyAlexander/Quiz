package ru.great_larder.sportquiz.database.mysql.request_get_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionService;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionServiceImpl;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.LanguageRuMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.LanguageRuMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionRuLanguage;
import ru.great_larder.sportquiz.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListLanguageRuQuestionMySQLImpl implements GetListQuestionMySQL {
    @Override
    public List<Question> getListQuestion(User user, Context context) {
        
        List<Question> questions = new ArrayList<>();
        
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableLanguageRuMySQL();
        
        LanguageRuMySQL languageRuMySQL = new LanguageRuMySQLImpl();
        GetQuestionService getQuestionService = new GetQuestionServiceImpl();
       
        try {
            connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(languageRuMySQL.SELECT(connectMySQL.nameDB));
            
            while (connectMySQL.resultSetMySQL.next()){
                Question question = new QuestionRuLanguage();
                questions.add(getQuestionService.getQuestion(connectMySQL, question));
            }
            
            connectMySQL.closeMySQLDatabase();
        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            connectMySQL.closeMySQLDatabase();
        }
        return questions;
    }
}
