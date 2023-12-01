package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionTatarLanguage;

import java.util.List;

public class ListTatarLanguageLoad {
	private static List<QuestionTatarLanguage> questionList;
	
	public static List<QuestionTatarLanguage> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionTatarLanguage> questionList) {
		ListTatarLanguageLoad.questionList = questionList;
	}
}
