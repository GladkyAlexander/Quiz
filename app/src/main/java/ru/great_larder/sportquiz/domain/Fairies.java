package ru.great_larder.sportquiz.domain;


import java.util.Date;

public class Fairies {
    Integer id;
    Integer idUser;
    String name;
    Integer price;
    Integer imageI;
    Date dateStart;
    Integer validity_period;
    Integer activity_fairies;
    
    public Fairies() {
    }
    
    public Fairies(Integer id, Integer idUser, String name, Integer price, Integer imageI, Date dateStart, Integer validity_period, Integer activity_fairies) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.price = price;
        this.imageI = imageI;
        this.dateStart = dateStart;
        this.validity_period = validity_period;
        this.activity_fairies = activity_fairies;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getIdUser() {
        return idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getPrice() {
        return price;
    }
    
    public void setPrice(Integer price) {
        this.price = price;
    }
    
    public Integer getImageI() {
        return imageI;
    }
    
    public void setImageI(Integer imageI) {
        this.imageI = imageI;
    }
    
    public Date getDateStart() {
        return dateStart;
    }
    
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }
    
    public Integer getValidity_period() {
        return validity_period;
    }
    
    public void setValidity_period(Integer validity_period) {
        this.validity_period = validity_period;
    }
    
    public Integer getActivity_fairies() {
        return activity_fairies;
    }
    
    public void setActivity_fairies(Integer activity_fairies) {
        this.activity_fairies = activity_fairies;
    }
    
    @Override
    public String toString() {
        return "Fairies{" +
            "id=" + id +
            ", idUser=" + idUser +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", imageI=" + imageI +
            ", dateStart=" + dateStart +
            ", validity_period=" + validity_period +
            ", activity_fairies=" + activity_fairies +
            '}';
    }
}