package ru.great_larder.sportquiz.domain;

import com.mysql.jdbc.Blob;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class User {
    long id;
    String name;
    String city;
    int glasses;
    int themeInstalledNow;
    String date_of_birth;
    byte[] awatar;
    String lastName;
    
    public User(String name, String city, int glasses, int themeInstalledNow, String date_of_birth, byte[] awatar, String lastName) {
        this.name = name;
        this.city = city;
        this.glasses = glasses;
        this.themeInstalledNow = themeInstalledNow;
        this.date_of_birth = date_of_birth;
        this.awatar = awatar;
        this.lastName = lastName;
    }
    public User(long id, String name, String city, int glasses, int themeInstalledNow, String date_of_birth, byte[] awatar, String lastName) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.glasses = glasses;
        this.themeInstalledNow = themeInstalledNow;
        this.date_of_birth = date_of_birth;
        this.awatar = awatar;
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getDate_of_birth() {
        return date_of_birth;
    }
    
    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
    
    public User() {
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getGlasses() {
        return glasses;
    }
    
    public void setGlasses(int glasses) {
        this.glasses = glasses;
    }
    
    public int getThemeInstalledNow() {
        return themeInstalledNow;
    }
    
    public void setThemeInstalledNow(int themeInstalledNow) {
        this.themeInstalledNow = themeInstalledNow;
    }
    
    public byte[] getAwatar() {
        return awatar;
    }
    
    public void setAwatar(byte[] awatar) {
        this.awatar = awatar;
    }
    
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", glasses=" + glasses +
            ", themeInstalledNow=" + themeInstalledNow +
            ", date_of_birth='" + date_of_birth + '\'' +
            ", awatar=" + Arrays.toString(awatar) +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}
