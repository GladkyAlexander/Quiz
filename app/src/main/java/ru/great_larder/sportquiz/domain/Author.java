package ru.great_larder.sportquiz.domain;

import java.util.Arrays;

public class Author {
    String lastNameAuthor;
    String firstNameAuthor;
    byte[] photo;
    
    public Author(String lastnameAuthor, String firstnameAuthor, byte[] photo) {
        this.lastNameAuthor = lastnameAuthor;
        this.firstNameAuthor = firstnameAuthor;
        this.photo = photo;
    }
    
    public Author() {
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
            "lastnameAuthor='" + lastNameAuthor + '\'' +
            ", firstnameAuthor='" + firstNameAuthor + '\'' +
            ", photo=" + Arrays.toString(photo) +
            '}';
    }
}
