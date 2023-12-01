package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.SetQuestionServices;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxSocialStudies;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.SocialStudiesMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

public class SetQuestionSocialStudiesMySQLImpl implements SetQuestion {
	@Override
	public Integer setQuestion(User user, Context context, Question question) {
		ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
		connectMySQL.createTableSocialStudiesMySQL();
		SyntaxSocialStudies socialStudiesMySQL = new SocialStudiesMySQLImpl();

		return new SetQuestionServices().setQuestionServices(question, connectMySQL, socialStudiesMySQL.INSERT(connectMySQL.nameDB));
	}
}
