package ru.great_larder.sportquiz.database.repository.impl;

import android.content.Context;
import ru.great_larder.sportquiz.database.repository.GetCompanyPartners;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.AuthorAdapterSQLite;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.CompanyPartnersAdapterSQLite;
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.domain.CompanyPartners;

import java.util.ArrayList;
import java.util.List;

public class GetCompanyPartnersImpl implements GetCompanyPartners {
    @Override
    public List<CompanyPartners> getCompanyPartners(Context context) {
        CompanyPartnersAdapterSQLite companyPartnersAdapterSQLite = new CompanyPartnersAdapterSQLite(context);
        companyPartnersAdapterSQLite.open();
        List<CompanyPartners> questionCompanyPartners = new ArrayList<>(companyPartnersAdapterSQLite.getCompanyPartners());
        companyPartnersAdapterSQLite.close();
        return questionCompanyPartners;
    }
}
