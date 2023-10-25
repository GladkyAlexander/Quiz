package ru.great_larder.sportquiz.domain;


import java.util.Arrays;

public class QuestionCity extends Question{
    String city;
    String linkHistoryOneStreet;
    byte[] label;
    
    public QuestionCity(Integer id, String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String link, int level, String city, String linkHistoryOneStreet, byte[] label) {
        super(id, question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, link, level);
        this.city = city;
        this.linkHistoryOneStreet = linkHistoryOneStreet;
        this.label = label;
    }
    
    public QuestionCity(String city, String linkHistoryOneStreet, byte[] label) {
        this.city = city;
        this.linkHistoryOneStreet = linkHistoryOneStreet;
        this.label = label;
    }
    
    public QuestionCity() {
    }
    
    public String getLinkHistoryOneStreet() {
        return linkHistoryOneStreet;
    }
    
    public void setLinkHistoryOneStreet(String linkHistoryOneStreet) {
        this.linkHistoryOneStreet = linkHistoryOneStreet;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public byte[] getLabel() {
        return label;
    }
    
    public void setLabel(byte[] label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return "QuestionCity{" +
            "city='" + city + '\'' +
            ", linkHistoryOneStreet='" + linkHistoryOneStreet + '\'' +
            ", label=" + Arrays.toString(label) +
            ", id=" + id +
            ", question='" + question + '\'' +
            ", rightAnswer='" + rightAnswer + '\'' +
            ", wrongAnswer1='" + wrongAnswer1 + '\'' +
            ", wrongAnswer2='" + wrongAnswer2 + '\'' +
            ", wrongAnswer3='" + wrongAnswer3 + '\'' +
            ", link='" + link + '\'' +
            ", level=" + level +
            '}';
    }
}
