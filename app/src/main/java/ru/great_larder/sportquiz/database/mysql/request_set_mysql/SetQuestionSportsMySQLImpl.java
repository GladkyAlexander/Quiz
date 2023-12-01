package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxSports;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.SportsMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionSportsMySQLImpl implements SetQuestion {
    @Override
    public Integer setQuestion(User user, Context context, Question question) {
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableSportsMySQL();
        SyntaxSports sportsMySQL = new SportsMySQLImpl();

        return new SetQuestionServices().setQuestionServices(question, connectMySQL, sportsMySQL.INSERT(connectMySQL.nameDB));
    }
}
