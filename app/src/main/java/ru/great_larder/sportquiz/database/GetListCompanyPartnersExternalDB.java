package ru.great_larder.sportquiz.database;

import android.content.Context;
import ru.great_larder.sportquiz.domain.CompanyPartners;
import ru.great_larder.sportquiz.domain.User;

import java.util.List;

public interface GetListCompanyPartnersExternalDB {
    List<CompanyPartners> getListCompanyPartners(User user, Context context);
}
