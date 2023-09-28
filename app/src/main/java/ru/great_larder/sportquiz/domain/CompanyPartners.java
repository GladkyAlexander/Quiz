package ru.great_larder.sportquiz.domain;

import java.util.Arrays;

public class CompanyPartners {
    String nameCompany;
    byte[] logo;
    
    public CompanyPartners(String nameCompany, byte[] logo) {
        this.nameCompany = nameCompany;
        this.logo = logo;
    }
    
    public CompanyPartners() {
    
    }
    
    public String getNameCompany() {
        return nameCompany;
    }
    
    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }
    
    public byte[] getLogo() {
        return logo;
    }
    
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
    @Override
    public String toString() {
        return "CompanyPartners{" +
            "nameCompany='" + nameCompany + '\'' +
            ", logo=" + Arrays.toString(logo) +
            '}';
    }
}
