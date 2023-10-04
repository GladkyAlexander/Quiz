package ru.great_larder.sportquiz.domain;

import org.jetbrains.annotations.NotNull;

public class Chapter {
    String name;
    Integer idResources;
    
    public Chapter(String name, Integer idResources) {
        this.name = name;
        this.idResources = idResources;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getIdResources() {
        return idResources;
    }
    
    public void setIdResources(Integer idResources) {
        this.idResources = idResources;
    }
    
    @NotNull
    @Override
    public String toString() {
        return "Chapter{" +
            "name='" + name + '\'' +
            ", idResources=" + idResources +
            '}';
    }
}
