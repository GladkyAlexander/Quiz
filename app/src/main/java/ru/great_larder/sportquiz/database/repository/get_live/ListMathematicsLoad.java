package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionMathematics;

import java.util.List;

public class ListMathematicsLoad {
    private static List<QuestionMathematics> questionList;
    
    public static List<QuestionMathematics> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionMathematics> questionList) {
        ListMathematicsLoad.questionList = questionList;
    }
}
