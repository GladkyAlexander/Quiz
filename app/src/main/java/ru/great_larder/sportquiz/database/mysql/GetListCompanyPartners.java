package ru.great_larder.sportquiz.database.mysql;

import android.content.Context;
import ru.great_larder.sportquiz.domain.CompanyPartners;
import ru.great_larder.sportquiz.domain.User;

import java.util.List;

public interface GetListCompanyPartners {
    List<CompanyPartners> getListCompanyPartners(User user, Context context);
}
