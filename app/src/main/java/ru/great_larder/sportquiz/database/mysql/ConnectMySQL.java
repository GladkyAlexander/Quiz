package ru.great_larder.sportquiz.database.mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.syntax_db.*;
import ru.great_larder.sportquiz.database.syntax_db.impl_mysql.*;
import ru.great_larder.sportquiz.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class ConnectMySQL {
    public User user;
    public String nameDB;
    public Connection connectionMySQL;
    public Statement statementMySQL;
    public ResultSet resultSetMySQL;
    
    public ConnectMySQL(User user, Context context) {
        this.user = user;
    }
    public synchronized void setConnectionMySQL(){
        if (user != null){
            String server = "www.great-larder.ru";
            String port = "3306";
            nameDB = "u1542203_victori";
            String passwordDB = "zZL-8PK-sgP-A6z";
            String userDB = "u1542203_victori";
            connectionMySQL = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
                    connectionMySQL = DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "?useSSL=false" ,  userDB , passwordDB);
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
    public synchronized void createTableLanguageRuMySQL(){
        setConnectionMySQL();
        try {
            SyntaxLanguageRu languageRuMySQL = new LanguageRuMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(languageRuMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableLanguageEnMySQL() {
        setConnectionMySQL();
        try {
            SyntaxLanguageEn languageEnMySQL = new LanguageEnMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(languageEnMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableBiologyMySQL() {
        setConnectionMySQL();
        try {
            SyntaxBiology biologyMySQL = new BiologyMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(biologyMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableEtiquetteBusinessMySQL() {
        setConnectionMySQL();
        try {
            SyntaxEtiquetteBusiness etiquetteBusinessMySQL = new EtiquetteBusinessMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(etiquetteBusinessMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableEtiquetteSecularMySQL() {
        setConnectionMySQL();
        try {
            SyntaxEtiquetteSecular etiquetteSecularMySQL = new EtiquetteSecularMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(etiquetteSecularMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableGeographyMySQL() {
        setConnectionMySQL();
        try {
            SyntaxGeography geographyMySQL = new GeographyMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(geographyMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableHistoryMySQL() {
        setConnectionMySQL();
        try {
            SyntaxHistory historyMySQL = new HistoryMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(historyMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableMathematicsMySQL() {
        setConnectionMySQL();
        try {
            SyntaxMathematics mathematicsMySQL = new MathematicsMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(mathematicsMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTablePhysicsMySQL() {
        setConnectionMySQL();
        try {
            SyntaxPhysics physicsMySQL = new PhysicsMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(physicsMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableSportsMySQL() {
        setConnectionMySQL();
        try {
            SyntaxSports sportsMySQL = new SportsMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(sportsMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    public synchronized void createTableCityMySQL() {
        setConnectionMySQL();
        try {
            SyntaxCity cityMySQL = new CityMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(cityMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    public synchronized void createTableAuthorMySQL() {
        setConnectionMySQL();
        try {
            SyntaxAuthor authorMySQL = new AuthorMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(authorMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableCompanyPartnersMySQL() {
        setConnectionMySQL();
        try {
            SyntaxCompanyPartners companyPartnersMySQL = new CompanyPartnersMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(companyPartnersMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public synchronized void createTableSocialStudiesMySQL() {
        setConnectionMySQL();
        try {
            SyntaxSocialStudies socialStudiesMySQL = new SocialStudiesMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(socialStudiesMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    public synchronized void createTableLanguageBashkirMySQL() {
        setConnectionMySQL();
        try {
            SyntaxLanguageBashkir languageBashkirMySQL = new LanguageBashkirMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(languageBashkirMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    public synchronized void createTableLanguageChuvashMySQL() {
        setConnectionMySQL();
        try {
            SyntaxLanguageChuvash languageChuvashMySQL = new LanguageChuvashMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(languageChuvashMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
	
	public void createTableAviationTransportMySQL() {
        setConnectionMySQL();
        try {
            SyntaxAviationTransport aviationTransportMySQL = new AviationTransportMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(aviationTransportMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
	}
    
    public void createTableLanguageChechenMySQL() {
        setConnectionMySQL();
        try {
            SyntaxLanguageChechen languageChechenMySQL = new LanguageChechenMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(languageChechenMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableLanguageTatarMySQL() {
        setConnectionMySQL();
        try {
            SyntaxLanguageTatar languageTatarMySQL = new LanguageTatarMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(languageTatarMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableRailwayTransportMySQL() {
        setConnectionMySQL();
        try {
            SyntaxRailwayTransport railwayTransportMySQL = new RailwayTransportMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(railwayTransportMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
    
    public void createTableRoadTransportMySQL() {
        setConnectionMySQL();
        try {
            SyntaxRoadTransport roadTransportMySQL = new RoadTransportMySQLImpl();
            if(connectionMySQL != null) {
                statementMySQL = connectionMySQL.createStatement();
                statementMySQL.execute(roadTransportMySQL.CREATE(nameDB));
            }
        } catch (java.sql.SQLException e) {
            System.err.print(e.getMessage());
        }
    }
}
