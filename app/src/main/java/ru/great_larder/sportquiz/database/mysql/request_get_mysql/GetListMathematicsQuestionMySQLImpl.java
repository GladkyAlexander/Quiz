package ru.great_larder.sportquiz.database.mysql.request_get_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionService;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionServiceImpl;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.MathematicsMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.MathematicsMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionMathematics;
import ru.great_larder.sportquiz.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListMathematicsQuestionMySQLImpl implements GetListQuestionMySQL {
    @Override
    public List<Question> getListQuestion(User user, Context context) {
        List<Question> questions = new ArrayList<>();
        
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableMathematicsMySQL();
        MathematicsMySQL mathematicsMySQL = new MathematicsMySQLImpl();
        GetQuestionService getQuestionService = new GetQuestionServiceImpl();
        try {
            connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(mathematicsMySQL.SELECT(connectMySQL.nameDB));
            
            while (connectMySQL.resultSetMySQL.next()){
                Question question = new QuestionMathematics();
                questions.add(getQuestionService.getQuestion(connectMySQL, question));
            }
            
            connectMySQL.closeMySQLDatabase();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        
        return questions;
    }
}
