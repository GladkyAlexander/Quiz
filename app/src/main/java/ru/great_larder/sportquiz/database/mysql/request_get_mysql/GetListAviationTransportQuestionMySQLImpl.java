package ru.great_larder.sportquiz.database.mysql.request_get_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListQuestionMySQL;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionService;
import ru.great_larder.sportquiz.database.mysql.service_dom_mysql.GetQuestionServiceImpl;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxAviationTransport;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.AviationTransportMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionAviationTransport;
import ru.great_larder.sportquiz.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListAviationTransportQuestionMySQLImpl implements GetListQuestionMySQL {
	@Override
	public List<Question> getListQuestion(User user, Context context) {
		List<Question> questions = new ArrayList<>();
		
		ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
		connectMySQL.createTableAviationTransportMySQL();
		SyntaxAviationTransport aviationTransportMySQL = new AviationTransportMySQLImpl();
		GetQuestionService getQuestionService = new GetQuestionServiceImpl();
		try {
			connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(aviationTransportMySQL.SELECT(connectMySQL.nameDB));
			
			while (connectMySQL.resultSetMySQL.next()){
				Question question = new QuestionAviationTransport();
				questions.add(getQuestionService.getQuestion(connectMySQL, question));
			}
			connectMySQL.closeMySQLDatabase();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return questions;
	}
}
