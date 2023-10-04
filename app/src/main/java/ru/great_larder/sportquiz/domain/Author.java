package ru.great_larder.sportquiz.domain;

import java.util.Arrays;

public class Author {
    String lastNameAuthor;
    String firstNameAuthor;
    String aboutMe;
    String link;
    byte[] photo;
    
    public Author(String lastNameAuthor, String firstNameAuthor, String aboutMe, String link, byte[] photo) {
        this.lastNameAuthor = lastNameAuthor;
        this.firstNameAuthor = firstNameAuthor;
        this.aboutMe = aboutMe;
        this.link = link;
        this.photo = photo;
    }
    
    public Author() {
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
    
    public String getLastNameAuthor() {
        return lastNameAuthor;
    }
    
    public void setLastNameAuthor(String lastNameAuthor) {
        this.lastNameAuthor = lastNameAuthor;
    }
    
    public String getFirstNameAuthor() {
        return firstNameAuthor;
    }
    
    public void setFirstNameAuthor(String firstNameAuthor) {
        this.firstNameAuthor = firstNameAuthor;
    }
    
    public byte[] getPhoto() {
        return photo;
    }
    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
    @Override
    public String toString() {
        return "Author{" +
            "lastNameAuthor='" + lastNameAuthor + '\'' +
            ", firstNameAuthor='" + firstNameAuthor + '\'' +
            ", aboutMe='" + aboutMe + '\'' +
            ", link='" + link + '\'' +
            ", photo=" + Arrays.toString(photo) +
            '}';
    }
}
