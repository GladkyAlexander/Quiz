package ru.great_larder.sportquiz.question.load_question;

import ru.great_larder.sportquiz.domain.Question;

import java.util.List;

public class ListHistoryLoad {
    private static List<Question> questionList;
    
    public static List<Question> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<Question> questionList) {
        ListHistoryLoad.questionList = questionList;
    }
}
