package ru.great_larder.sportquiz.database.author_and_partners;

import ru.great_larder.sportquiz.domain.CompanyPartners;

import java.util.List;

public class ListLoadCompanyPartners {
    private static List<CompanyPartners> companyPartners;
    
    public static List<CompanyPartners> getCompanyPartners() {
        return companyPartners;
    }
    
    public static void setCompanyPartners(List<CompanyPartners> companyPartners) {
        ListLoadCompanyPartners.companyPartners = companyPartners;
    }
}
