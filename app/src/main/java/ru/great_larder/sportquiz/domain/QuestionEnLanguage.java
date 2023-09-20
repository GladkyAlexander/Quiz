package ru.great_larder.sportquiz.domain;

public class QuestionEnLanguage extends Question{
    public QuestionEnLanguage(String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String link, int level) {
        super(question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, link, level);
    }
    
    public QuestionEnLanguage() {
    }
    
    @Override
    public String toString() {
        return "QuestionEnLanguage{" +
            "question='" + question + '\'' +
            ", rightAnswer='" + rightAnswer + '\'' +
            ", wrongAnswer1='" + wrongAnswer1 + '\'' +
            ", wrongAnswer2='" + wrongAnswer2 + '\'' +
            ", wrongAnswer3='" + wrongAnswer3 + '\'' +
            ", link='" + link + '\'' +
            ", level=" + level +
            '}';
    }
}
