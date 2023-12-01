package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxBiology;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.BiologyMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionBiologyMySQLImpl implements SetQuestion {
    @Override
    public Integer setQuestion(User user, Context context, Question question) {
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableBiologyMySQL();
        SyntaxBiology biologyMySQL = new BiologyMySQLImpl();
        
        return new SetQuestionServices().setQuestionServices(question, connectMySQL, biologyMySQL.INSERT(connectMySQL.nameDB));
    }
}
