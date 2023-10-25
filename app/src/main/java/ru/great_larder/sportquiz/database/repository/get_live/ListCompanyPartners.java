package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.CompanyPartners;

import java.util.List;

public class ListCompanyPartners {
    private static List<CompanyPartners> companyPartners;
    
    public static List<CompanyPartners> getCompanyPartners() {
        return companyPartners;
    }
    
    public static void setCompanyPartners(List<CompanyPartners> companyPartners) {
        ListCompanyPartners.companyPartners = companyPartners;
    }
}
