package ru.great_larder.sportquiz.domain;

import android.media.Image;

public class Fon {
    int id;
    String name;
    int price;
    int affiliation;
    int imageI;
    
    
    public Fon() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
  
    
    public int getAffiliation() {
        return affiliation;
    }
    
    public void setAffiliation(int affiliation) {
        this.affiliation = affiliation;
    }
    
    public int getImageI() {
        return imageI;
    }
    
    public void setImageI(int imageI) {
        this.imageI = imageI;
    }
    
    @Override
    public String toString() {
        return "Fon{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", affiliation=" + affiliation +
            ", imageI=" + imageI +
            '}';
    }
}
