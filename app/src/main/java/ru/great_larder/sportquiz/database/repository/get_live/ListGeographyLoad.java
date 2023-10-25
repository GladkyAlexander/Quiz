package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionGeography;

import java.util.List;

public class ListGeographyLoad {
    private static List<QuestionGeography> questionList;
    
    public static List<QuestionGeography> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionGeography> questionList) {
        ListGeographyLoad.questionList = questionList;
    }
}
