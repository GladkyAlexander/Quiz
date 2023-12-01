package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxEtiquetteSecular;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.EtiquetteSecularMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionEtiquetteSecularMySQLImpl implements SetQuestion {
    @Override
    public Integer setQuestion(User user, Context context, Question question) {
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableEtiquetteSecularMySQL();
        SyntaxEtiquetteSecular etiquetteSecularMySQL = new EtiquetteSecularMySQLImpl();
  
        return new SetQuestionServices().setQuestionServices(question, connectMySQL, etiquetteSecularMySQL.INSERT(connectMySQL.nameDB));
    }
}
