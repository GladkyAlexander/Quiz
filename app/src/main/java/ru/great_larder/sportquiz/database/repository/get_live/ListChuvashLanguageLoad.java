package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionChuvashLanguage;

import java.util.List;

public class ListChuvashLanguageLoad {
	private static List<QuestionChuvashLanguage> questionList;
	
	public static List<QuestionChuvashLanguage> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionChuvashLanguage> questionList) {
		ListChuvashLanguageLoad.questionList = questionList;
	}
}
