package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionBiology;

import java.util.List;

public class ListBiologyLoad {
    private static List<QuestionBiology> questionList;
    
    public static List<QuestionBiology> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionBiology> questionList) {
        ListBiologyLoad.questionList = questionList;
    }
}
