package ru.great_larder.sportquiz.domain;

import java.util.Arrays;

public class CompanyPartners {
    Integer id;
    String nameCompany;
    String aboutMe;
    String link;
    byte[] logo;
    
    public CompanyPartners(Integer id, String nameCompany, String aboutMe, String link, byte[] logo) {
        this.id = id;
        this.nameCompany = nameCompany;
        this.aboutMe = aboutMe;
        this.link = link;
        this.logo = logo;
    }
    
    public CompanyPartners() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
            "id=" + id +
            ", nameCompany='" + nameCompany + '\'' +
            ", aboutMe='" + aboutMe + '\'' +
            ", link='" + link + '\'' +
            ", logo=" + Arrays.toString(logo) +
            '}';
    }
}
