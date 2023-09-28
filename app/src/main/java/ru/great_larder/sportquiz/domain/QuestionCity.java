package ru.great_larder.sportquiz.domain;

import org.jetbrains.annotations.NotNull;

import java.sql.Blob;
import java.util.Arrays;

public class QuestionCity extends Question{
    String city;
    byte[] label;
    
    public QuestionCity(String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String link, int level, String city, byte[] label) {
        super(question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, link, level);
        this.city = city;
        this.label = label;
    }
    
    public QuestionCity(String city, byte[] label) {
        this.city = city;
        this.label = label;
    }
    
    public QuestionCity() {
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
            ", label=" + Arrays.toString(label) +
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
