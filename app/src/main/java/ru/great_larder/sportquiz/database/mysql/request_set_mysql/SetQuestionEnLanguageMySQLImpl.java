package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxLanguageEn;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.LanguageEnMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionEnLanguageMySQLImpl implements SetQuestion {
    @Override
    public Integer setQuestion(User user, Context context, Question question) {
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableLanguageEnMySQL();
        SyntaxLanguageEn languageEnMySQL = new LanguageEnMySQLImpl();
        
        return new SetQuestionServices().setQuestionServices(question, connectMySQL, languageEnMySQL.INSERT(connectMySQL.nameDB));
    }
}
