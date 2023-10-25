package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionRuLanguage;

import java.util.List;

public class ListRuLanguageLoad {
    private static List<QuestionRuLanguage> questionList;
    
    public static List<QuestionRuLanguage> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionRuLanguage> questionList) {
        ListRuLanguageLoad.questionList = questionList;
    }
}
