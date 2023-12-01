package ru.great_larder.sportquiz.database.syntax_db.impl_sqlite;

import ru.great_larder.sportquiz.database.syntax_db.SyntaxAviationTransport;

public class AviationTransportSQLiteImpl implements SyntaxAviationTransport {
	@Override
	public String CREATE(String nameDB) {
		return "CREATE TABLE if not exists aviation_transport (id int " +
				       ", question text" +
				       ", right_answer text" +
				       ", wrong_answer_1 text" +
				       ", wrong_answer_2 text" +
				       ", wrong_answer_3 text" +
				       ", link text" +
				       ", level text);";
	}
	
	@Override
	public String INSERT(String nameDB) {
		return "INSERT INTO aviation_transport ( " +
				       " question," +
				       " right_answer," +
				       " wrong_answer_1," +
				       " wrong_answer_2," +
				       " wrong_answer_3," +
				       " link," +
				       " level) " +
				       " VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	public String UPDATE(String nameDB) {
		return "UPDATE aviation_transport SET " +
				       " question = ?," +
				       " right_answer = ?," +
				       " wrong_answer_1 = ?," +
				       " wrong_answer_2 = ?," +
				       " wrong_answer_3 = ?," +
				       " link = ?," +
				       " level = ? WHERE id = ? ";
	}
	
	@Override
	public String SELECT(String nameDB) {
		return "SELECT * FROM aviation_transport";
	}
}
