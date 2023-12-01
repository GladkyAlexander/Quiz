package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxLanguageBashkir;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.LanguageBashkirMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionBashkirLanguageMySQLImpl implements SetQuestion {
	@Override
	public Integer setQuestion(User user, Context context, Question question) {
		ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
		connectMySQL.createTableLanguageBashkirMySQL();
		SyntaxLanguageBashkir languageBashkirMySQL = new LanguageBashkirMySQLImpl();
		
		return new SetQuestionServices().setQuestionServices(question, connectMySQL, languageBashkirMySQL.INSERT(connectMySQL.nameDB));
	}
}
