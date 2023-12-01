package ru.great_larder.sportquiz.database.mysql.service_dom_mysql;

import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.domain.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetQuestionServices {
	public Integer setQuestionServices(Question question, ConnectMySQL connectMySQL, String insert) {
		try {
			PreparedStatement ps = connectMySQL.connectionMySQL.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, question.getQuestion());
			ps.setString(2, question.getRightAnswer());
			ps.setString(3, question.getWrongAnswer1());
			ps.setString(4, question.getWrongAnswer2());
			ps.setString(5, question.getWrongAnswer3());
			ps.setString(6, question.getLink());
			ps.setString(7, String.valueOf(question.getLevel()));
			
			if(ps.executeUpdate() > 0){
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					return rs.getInt(1);
				}
			}
			connectMySQL.closeMySQLDatabase();
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		} finally {
			connectMySQL.closeMySQLDatabase();
		}
		return null;
	}
}
