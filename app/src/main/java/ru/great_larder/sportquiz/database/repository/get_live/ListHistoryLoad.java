package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionHistory;

import java.util.List;

public class ListHistoryLoad {
    private static List<QuestionHistory> questionList;
    
    public static List<QuestionHistory> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionHistory> questionList) {
        ListHistoryLoad.questionList = questionList;
    }
}
