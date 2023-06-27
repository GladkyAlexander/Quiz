package ru.great_larder.sportquiz.domain;

public class Question {
    String question;
    String rightAnswer;
    String wrongAnswer1;
    String wrongAnswer2;
    String wrongAnswer3;
    int level;
    
    public Question(String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, int level) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
        this.level = level;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String getRightAnswer() {
        return rightAnswer;
    }
    
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
    
    public String getWrongAnswer1() {
        return wrongAnswer1;
    }
    
    public void setWrongAnswer1(String wrongAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }
    
    public String getWrongAnswer2() {
        return wrongAnswer2;
    }
    
    public void setWrongAnswer2(String wrongAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }
    
    public String getWrongAnswer3() {
        return wrongAnswer3;
    }
    
    public void setWrongAnswer3(String wrongAnswer3) {
        this.wrongAnswer3 = wrongAnswer3;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public String toString() {
        return "Question{" +
            "question='" + question + '\'' +
            ", rightAnswer='" + rightAnswer + '\'' +
            ", wrongAnswer1='" + wrongAnswer1 + '\'' +
            ", wrongAnswer2='" + wrongAnswer2 + '\'' +
            ", wrongAnswer3='" + wrongAnswer3 + '\'' +
            ", level=" + level +
            '}';
    }
}
