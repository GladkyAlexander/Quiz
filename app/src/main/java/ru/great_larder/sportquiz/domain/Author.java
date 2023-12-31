package ru.great_larder.sportquiz.domain;

import java.util.Arrays;

public class Author {
    Integer id;
    String lastNameAuthor;
    String firstNameAuthor;
    String aboutMe;
    String link;
    byte[] photo;
    
    public Author(Integer id, String lastNameAuthor, String firstNameAuthor, String aboutMe, String link, byte[] photo) {
        this.id = id;
        this.lastNameAuthor = lastNameAuthor;
        this.firstNameAuthor = firstNameAuthor;
        this.aboutMe = aboutMe;
        this.link = link;
        this.photo = photo;
    }
    
    public Author() {
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
            "id=" + id +
            ", lastNameAuthor='" + lastNameAuthor + '\'' +
            ", firstNameAuthor='" + firstNameAuthor + '\'' +
            ", aboutMe='" + aboutMe + '\'' +
            ", link='" + link + '\'' +
            ", photo=" + Arrays.toString(photo) +
            '}';
    }
}
