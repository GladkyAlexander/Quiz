package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionPhysics;

import java.util.List;

public class ListPhysicsLoad {
    private static List<QuestionPhysics> questionList;
    
    public static List<QuestionPhysics> getQuestionList() {
        return questionList;
    }
    
    public static void setQuestionList(List<QuestionPhysics> questionList) {
        ListPhysicsLoad.questionList = questionList;
    }
}
