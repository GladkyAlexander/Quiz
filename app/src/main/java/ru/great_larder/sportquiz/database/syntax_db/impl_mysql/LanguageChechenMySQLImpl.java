package ru.great_larder.sportquiz.database.syntax_db.impl_mysql;

import ru.great_larder.sportquiz.database.syntax_db.SyntaxLanguageChechen;

public class LanguageChechenMySQLImpl implements SyntaxLanguageChechen {
	@Override
	public String CREATE(String nameDB) {
		return "CREATE TABLE if not exists`" + nameDB + "`.`language_chechen` (id int AUTO_INCREMENT primary key NOT NULL" +
				       ", question text" +
				       ", right_answer text" +
				       ", wrong_answer_1 text" +
				       ", wrong_answer_2 text" +
				       ", wrong_answer_3 text" +
				       ", link text" +
				       ", level text) ENGINE = InnoDB";
	}
	
	@Override
	public String INSERT(String nameDB) {
		return "INSERT INTO `" + nameDB + "`.`language_chechen` ( " +
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
		return "UPDATE `" + nameDB + "`.`language_chechen` SET " +
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
		return "SELECT * FROM `" + nameDB + "`.`language_chechen`";
	}
}