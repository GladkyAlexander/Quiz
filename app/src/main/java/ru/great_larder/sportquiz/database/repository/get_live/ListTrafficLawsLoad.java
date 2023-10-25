package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionTrafficLaws;

import java.util.ArrayList;
import java.util.List;

public class ListTrafficLawsLoad {
    private static final List<QuestionTrafficLaws> questionList = new ArrayList<>();
    
    public static List<QuestionTrafficLaws> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionTrafficLaws> questionList) {
        ListTrafficLawsLoad.questionList.addAll(questionList);
    }
}
