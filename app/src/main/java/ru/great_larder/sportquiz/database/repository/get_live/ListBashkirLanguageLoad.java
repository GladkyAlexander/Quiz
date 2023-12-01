package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionBashkirLanguage;

import java.util.List;

public class ListBashkirLanguageLoad {
	private static List<QuestionBashkirLanguage> questionList;
	
	public static List<QuestionBashkirLanguage> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionBashkirLanguage> questionList) {
		ListBashkirLanguageLoad.questionList = questionList;
	}
}
