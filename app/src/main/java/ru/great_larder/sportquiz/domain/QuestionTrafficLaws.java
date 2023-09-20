package ru.great_larder.sportquiz.domain;

public class QuestionTrafficLaws extends Question{
    public QuestionTrafficLaws(String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String link, int level) {
        super(question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, link, level);
    }
    
    public QuestionTrafficLaws() {
    }
    
    @Override
    public String toString() {
        return "QuestionTrafficLaws{" +
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
