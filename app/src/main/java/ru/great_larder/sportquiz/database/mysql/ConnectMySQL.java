package ru.great_larder.sportquiz.database.mysql;

import android.content.Context;
import android.widget.Toast;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.*;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.*;
import ru.great_larder.sportquiz.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class ConnectMySQL {
    private final User user;
    public String nameDB;
    public Connection connectionMySQL;
    public Statement statementMySQL;
    public ResultSet resultSetMySQL;
    
    LanguageRuMySQL languageRuMySQL = new LanguageRuMySQLImpl();
    LanguageRuMySQL languageEnMySQL = new LanguageRuMySQLImpl();
    BiologyMySQL biologyMySQL = new BiologyMySQLImpl();
    EtiquetteBusinessMySQL etiquetteBusinessMySQL = new EtiquetteBusinessMySQLImpl();
    EtiquetteSecularMySQL etiquetteSecularMySQL = new EtiquetteSecularMySQLImpl();
    GeographyMySQL geographyMySQL = new GeographyMySQLImpl();
    HistoryMySQL historyMySQL = new HistoryMySQLImpl();
    MathematicsMySQL mathematicsMySQL = new MathematicsMySQLImpl();
    PhysicsMySQL physicsMySQL = new PhysicsMySQLImpl();
    SportsMySQL sportsMySQL = new SportsMySQLImpl();
    TrafficLawsMySQL trafficLawsMySQL = new TrafficLawsMySQLImpl();
    
    public ConnectMySQL(User user, Context context) {
        this.user = user;
    }
    public void setConnectionMySQL(){
        if (user != null){
            String server = "31.31.198.112";
            String port = "3306";
            nameDB = "u1542203_victori";
            String passwordDB = "zZL-8PK-sgP-A6z";
            String userDB = "u1542203_victori";
           
                try {
                    Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
                   
                    connectionMySQL = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port ,  userDB , passwordDB);
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | SQLException |
                         ClassNotFoundException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
    }
    }
    public void closeMySQLDatabase(){
        try {
            if(resultSetMySQL != null) resultSetMySQL.close();
            if(statementMySQL != null) statementMySQL.close();
            if (connectionMySQL != null) connectionMySQL.close();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTableLanguageRuMySQL(){
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(languageRuMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableLanguageEnMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(languageEnMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableBiologyMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(biologyMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableEtiquetteBusinessMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(etiquetteBusinessMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableEtiquetteSecularMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(etiquetteSecularMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableGeographyMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(geographyMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableHistoryMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(historyMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableMathematicsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(mathematicsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTablePhysicsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(physicsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableSportsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(sportsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void createTableTrafficLawsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(trafficLawsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
