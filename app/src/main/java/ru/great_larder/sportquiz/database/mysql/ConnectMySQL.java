package ru.great_larder.sportquiz.database.mysql;

import android.content.Context;
import android.widget.Toast;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.*;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.*;
import ru.great_larder.sportquiz.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Properties;

public class ConnectMySQL {
    public User user;
    public String nameDB;
    public Connection connectionMySQL;
    public Statement statementMySQL;
    public ResultSet resultSetMySQL;
    
    LanguageRuMySQL languageRuMySQL = new LanguageRuMySQLImpl();
    LanguageEnMySQL languageEnMySQL = new LanguageEnMySQLImpl();
    BiologyMySQL biologyMySQL = new BiologyMySQLImpl();
    EtiquetteBusinessMySQL etiquetteBusinessMySQL = new EtiquetteBusinessMySQLImpl();
    EtiquetteSecularMySQL etiquetteSecularMySQL = new EtiquetteSecularMySQLImpl();
    GeographyMySQL geographyMySQL = new GeographyMySQLImpl();
    HistoryMySQL historyMySQL = new HistoryMySQLImpl();
    MathematicsMySQL mathematicsMySQL = new MathematicsMySQLImpl();
    PhysicsMySQL physicsMySQL = new PhysicsMySQLImpl();
    SportsMySQL sportsMySQL = new SportsMySQLImpl();
    TrafficLawsMySQL trafficLawsMySQL = new TrafficLawsMySQLImpl();
    CityMySQL cityMySQL = new CityMySQLImpl();
    AuthorMySQL authorMySQL = new AuthorMySQLImpl();
    CompanyPartnersMySQL companyPartnersMySQL = new CompanyPartnersMySQLImpl();
    
    public ConnectMySQL(User user, Context context) {
        this.user = user;
    }
    public void setConnectionMySQL(){
        if (user != null){
            String server = "www.great-larder.ru";
            String port = "3306";
            nameDB = "u1542203_victori";
            String passwordDB = "zZL-8PK-sgP-A6z";
            String userDB = "u1542203_victori";
            connectionMySQL = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
                    connectionMySQL = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port ,  userDB , passwordDB);
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException | SQLException |
                         ClassNotFoundException | NoSuchMethodException e) {
                   System.err.print(e.getMessage());
                }
    }
    }
    
    public void closeMySQLDatabase(){
        try {
            if(resultSetMySQL != null) resultSetMySQL.close();
            if(statementMySQL != null) statementMySQL.close();
            if (connectionMySQL != null) connectionMySQL.close();
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    public void createTableLanguageRuMySQL(){
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(languageRuMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableLanguageEnMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(languageEnMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableBiologyMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(biologyMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableEtiquetteBusinessMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(etiquetteBusinessMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableEtiquetteSecularMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(etiquetteSecularMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableGeographyMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(geographyMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableHistoryMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(historyMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableMathematicsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(mathematicsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTablePhysicsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(physicsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableSportsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(sportsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableTrafficLawsMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(trafficLawsMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    public void createTableCityMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(cityMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    public void createTableAuthorMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(authorMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableCompanyPartnersMySQL() {
        setConnectionMySQL();
        try {
            statementMySQL = connectionMySQL.createStatement();
            statementMySQL.execute(companyPartnersMySQL.CREATE(nameDB));
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
}
