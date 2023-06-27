package ru.great_larder.sportquiz.domain;


import java.util.List;

public class User {
    long id;
    String name;
    int glasses;
    int themeInstalledNow;
    
    public User(String name, int glasses, int themeInstalledNow) {
        this.name = name;
        this.glasses = glasses;
        this.themeInstalledNow = themeInstalledNow;
    }
    
    List<Fon> fonList;
    
    public User() {
    }
    
    public User(int id, String name, int glasses, List<Fon> fonList) {
        this.id = id;
        this.name = name;
        this.glasses = glasses;
        this.fonList = fonList;
    }
    
    public User(String name, int glasses) {
        this.name = name;
        this.glasses = glasses;
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
            ", glasses=" + glasses +
            ", themeInstalledNow=" + themeInstalledNow +
            ", fonList=" + fonList +
            '}';
    }
}
