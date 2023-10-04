package ru.great_larder.sportquiz.domain;

import java.util.Arrays;

public class CompanyPartners {
    String nameCompany;
    String aboutMe;
    String link;
    byte[] logo;
    
    public CompanyPartners(String nameCompany, String aboutMe, String link, byte[] logo) {
        this.nameCompany = nameCompany;
        this.aboutMe = aboutMe;
        this.link = link;
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
    
    public String getAboutMe() {
        return aboutMe;
    }
    
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    
    public String getLink() {
        return link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }
    
    @Override
    public String toString() {
        return "CompanyPartners{" +
            "nameCompany='" + nameCompany + '\'' +
            ", aboutMe='" + aboutMe + '\'' +
            ", link='" + link + '\'' +
            ", logo=" + Arrays.toString(logo) +
            '}';
    }
}
