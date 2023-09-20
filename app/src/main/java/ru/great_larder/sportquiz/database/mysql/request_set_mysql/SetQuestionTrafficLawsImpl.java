package ru.great_larder.sportquiz.database.mysql.request_set_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.MathematicsMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.TrafficLawsMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.MathematicsMySQLImpl;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.TrafficLawsMySQLImpl;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SetQuestionTrafficLawsImpl implements SetQuestion {
    @Override
    public Integer setQuestion(User user, Context context, Question question) {
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableTrafficLawsMySQL();
        TrafficLawsMySQL trafficLawsMySQL = new TrafficLawsMySQLImpl();
        
        try {
            PreparedStatement ps = connectMySQL.connectionMySQL.prepareStatement(trafficLawsMySQL.INSERT(user.getName()), Statement.RETURN_GENERATED_KEYS);
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
