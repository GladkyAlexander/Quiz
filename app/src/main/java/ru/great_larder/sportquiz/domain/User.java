package ru.great_larder.sportquiz.domain;


import java.util.List;

public class User {
    long id;
    String name;
    String city;
    int glasses;
    int themeInstalledNow;
    
    public User(String name, String city, int glasses, int themeInstalledNow) {
        this.name = name;
        this.city = city;
        this.glasses = glasses;
        this.themeInstalledNow = themeInstalledNow;
    }
    
    public User() {
    }
    
    List<Fon> fonList;
    
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
    
    public List<Fon> getFonList() {
        return fonList;
    }
    
    public void setFonList(List<Fon> fonList) {
        this.fonList = fonList;
    }
    
    public int getThemeInstalledNow() {
        return themeInstalledNow;
    }
    
    public void setThemeInstalledNow(int themeInstalledNow) {
        this.themeInstalledNow = themeInstalledNow;
    }
    
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", glasses=" + glasses +
            ", themeInstalledNow=" + themeInstalledNow +
            ", fonList=" + fonList +
            '}';
    }
}
