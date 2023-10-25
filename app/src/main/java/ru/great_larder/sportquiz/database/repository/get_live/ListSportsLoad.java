package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionSports;

import java.util.List;

public class ListSportsLoad {
    private static List<QuestionSports> questionList;
    
    public static List<QuestionSports> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionSports> questionList) {
        ListSportsLoad.questionList = questionList;
    }
}
