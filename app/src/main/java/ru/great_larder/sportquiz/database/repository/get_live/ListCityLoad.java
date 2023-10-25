package ru.great_larder.sportquiz.database.repository.get_live;
import ru.great_larder.sportquiz.domain.QuestionCity;

import java.util.List;

public class ListCityLoad {
    private static List<QuestionCity> questionList;
    
    public static List<QuestionCity> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionCity> questionList) {
        ListCityLoad.questionList = questionList;
    }
}
