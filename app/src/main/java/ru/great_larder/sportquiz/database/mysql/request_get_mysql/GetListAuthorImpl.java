package ru.great_larder.sportquiz.database.mysql.request_get_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.GetListAuthorExternalDB;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.AuthorMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.AuthorMySQLImpl;
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.domain.User;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListAuthorImpl implements GetListAuthorExternalDB {
    @Override
    public List<Author> getListAuthor(User user, Context context) {
        List<Author> authors = new ArrayList<>();
        
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableAuthorMySQL();
        AuthorMySQL authorMySQL = new AuthorMySQLImpl();
        try {
            connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(authorMySQL.SELECT(connectMySQL.nameDB));
            
            while (connectMySQL.resultSetMySQL.next()){
                
                Author author = new Author();
                author.setId(connectMySQL.resultSetMySQL.getInt("id"));
                author.setLastNameAuthor(connectMySQL.resultSetMySQL.getString("lastNameAuthor"));
                author.setFirstNameAuthor(connectMySQL.resultSetMySQL.getString("firstNameAuthor"));
                author.setAboutMe(connectMySQL.resultSetMySQL.getString("aboutMe"));
                author.setLink(connectMySQL.resultSetMySQL.getString("link"));
                
                Blob blob = connectMySQL.resultSetMySQL.getBlob("photo");
                int blobLength = (int) blob.length();
                
                author.setPhoto(blob.getBytes(1, blobLength));
                
                authors.add(author);
            }
            
            connectMySQL.closeMySQLDatabase();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        
        return authors;
    }
}
