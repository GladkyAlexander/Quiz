package ru.great_larder.sportquiz.database.repository;

import android.content.Context;
import ru.great_larder.sportquiz.domain.CompanyPartners;

import java.util.List;

public interface GetCompanyPartners {
    List<CompanyPartners> getCompanyPartners(Context context);
}
