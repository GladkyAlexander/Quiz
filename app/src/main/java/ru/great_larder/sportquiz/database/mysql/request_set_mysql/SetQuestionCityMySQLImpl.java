package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.syntax_db.SyntaxCity;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.CityMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetQuestionCityMySQLImpl implements SetQuestion {
    @Override
    public Integer setQuestion(User user, Context context, Question question) {
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableCityMySQL();
        SyntaxCity cityMySQL = new CityMySQLImpl();
        
        try {
            PreparedStatement ps = connectMySQL.connectionMySQL.prepareStatement(cityMySQL.INSERT(user.getName()), Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, question.getQuestion());
            ps.setString(2, question.getRightAnswer());
            ps.setString(3, question.getWrongAnswer1());
            ps.setString(4, question.getWrongAnswer2());
            ps.setString(5, question.getWrongAnswer3());
            ps.setString(6, question.getLink());
            ps.setString(7, String.valueOf(question.getLevel()));
            ps.setString(8, ((QuestionCity)question).getCity());
            ps.setString(9, ((QuestionCity) question).getLinkHistoryOneStreet());
            ps.setBlob(10, new ByteArrayInputStream(((QuestionCity) question).getLabel()));
            
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
