package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionEtiquetteBusiness;

import java.util.List;

public class ListEtiquetteBusinessLoad {
    private static List<QuestionEtiquetteBusiness> questionList;
    
    public static List<QuestionEtiquetteBusiness> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionEtiquetteBusiness> questionList) {
        ListEtiquetteBusinessLoad.questionList = questionList;
    }
}
