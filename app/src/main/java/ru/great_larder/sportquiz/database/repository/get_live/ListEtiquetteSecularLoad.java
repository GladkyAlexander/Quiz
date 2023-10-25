package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionEtiquetteSecular;

import java.util.List;

public class ListEtiquetteSecularLoad {
    private static List<QuestionEtiquetteSecular> questionList;
    
    public static List<QuestionEtiquetteSecular> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionEtiquetteSecular> questionList) {
        ListEtiquetteSecularLoad.questionList = questionList;
    }
}
