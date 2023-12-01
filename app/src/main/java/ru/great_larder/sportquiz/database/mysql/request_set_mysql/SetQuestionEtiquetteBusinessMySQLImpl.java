package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxEtiquetteBusiness;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.EtiquetteBusinessMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionEtiquetteBusinessMySQLImpl implements SetQuestion {
    @Override
    public Integer setQuestion(User user, Context context, Question question) {
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableEtiquetteBusinessMySQL();
        SyntaxEtiquetteBusiness etiquetteBusinessMySQL = new EtiquetteBusinessMySQLImpl();

        return new SetQuestionServices().setQuestionServices(question, connectMySQL, etiquetteBusinessMySQL.INSERT(connectMySQL.nameDB));
    }
}
