package ru.great_larder.sportquiz.database.syntax_db.impl_mysql;

import ru.great_larder.sportquiz.database.syntax_db.SyntaxSocialStudies;

public class SocialStudiesMySQLImpl implements SyntaxSocialStudies {
	@Override
	public String CREATE(String nameDB) {
		return "CREATE TABLE if not exists`" + nameDB + "`.`social_studies` (id int AUTO_INCREMENT primary key NOT NULL" +
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
		return "INSERT INTO `" + nameDB + "`.`social_studies` (" +
				       " question," +
				       " right_answer," +
				       " wrong_answer_1," +
				       " wrong_answer_2," +
				       " wrong_answer_3," +
				       " link," +
				       " level) VALUES (?,?,?,?,?,?,?)";
	}
	
	@Override
	public String UPDATE(String nameDB) {
		return "UPDATE social_studies SET " +
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
		return "SELECT * FROM `" + nameDB + "`.`social_studies`";
	}
}
