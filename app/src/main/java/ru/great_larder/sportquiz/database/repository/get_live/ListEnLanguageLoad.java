package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionEnLanguage;

import java.util.List;

public class ListEnLanguageLoad {
    private static List<QuestionEnLanguage> questionList;
    
    public static List<QuestionEnLanguage> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionEnLanguage> questionList) {
        ListEnLanguageLoad.questionList = questionList;
    }
}
