package ru.great_larder.sportquiz.database.mysql.request_get_mysql;

import android.content.Context;
import ru.great_larder.sportquiz.database.mysql.ConnectMySQL;
import ru.great_larder.sportquiz.database.mysql.GetListCompanyPartners;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.AuthorMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.CompanyPartnersMySQL;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.AuthorMySQLImpl;
import ru.great_larder.sportquiz.database.mysql.sintax_mysql.impl.CompanyPartnersMySQLImpl;
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.domain.CompanyPartners;
import ru.great_larder.sportquiz.domain.User;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetListCompanyPartnersImpl implements GetListCompanyPartners {
    @Override
    public List<CompanyPartners> getListCompanyPartners(User user, Context context) {
        List<CompanyPartners> companyPartners = new ArrayList<>();
        
        ConnectMySQL connectMySQL = new ConnectMySQL(user, context);
        connectMySQL.createTableCompanyPartnersMySQL();
        CompanyPartnersMySQL companyPartnersMySQL = new CompanyPartnersMySQLImpl();
        try {
            connectMySQL.resultSetMySQL = connectMySQL.statementMySQL.executeQuery(companyPartnersMySQL.SELECT(connectMySQL.nameDB));
            
            while (connectMySQL.resultSetMySQL.next()){
                
                CompanyPartners partners = new CompanyPartners();
                partners.setNameCompany(connectMySQL.resultSetMySQL.getString("name"));
                partners.setAboutMe(connectMySQL.resultSetMySQL.getString("aboutMe"));
                partners.setLink(connectMySQL.resultSetMySQL.getString("link"));
                
                Blob blob = connectMySQL.resultSetMySQL.getBlob("logo");
                int blobLength = (int) blob.length();
                
                partners.setLogo(blob.getBytes(1, blobLength));
                
                companyPartners.add(partners);
            }
            
            connectMySQL.closeMySQLDatabase();
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return companyPartners;
    }
}
