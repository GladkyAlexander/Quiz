package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxAviationTransport;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.AviationTransportMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionAviationTransportMySQLImpl implements SetQuestion {
	@Override
	public Integer setQuestion(User user, Context context, Question question) {
		ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
		connectMySQL.createTableAviationTransportMySQL();
		SyntaxAviationTransport aviationTransportMySQL = new AviationTransportMySQLImpl();
		
		return new SetQuestionServices().setQuestionServices(question, connectMySQL, aviationTransportMySQL.INSERT(connectMySQL.nameDB));
	}
	
}
