package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionChechenLanguage;

import java.util.List;

public class ListChechenLanguageLoad {
	private static List<QuestionChechenLanguage> questionList;
	
	public static List<QuestionChechenLanguage> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionChechenLanguage> questionList) {
		ListChechenLanguageLoad.questionList = questionList;
	}
}
