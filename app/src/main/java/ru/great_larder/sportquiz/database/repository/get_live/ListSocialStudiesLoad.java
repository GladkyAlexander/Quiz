package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionSocialStudies;

import java.util.List;

public class ListSocialStudiesLoad {
	private static List<QuestionSocialStudies> questionList;
	
	public static List<QuestionSocialStudies> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionSocialStudies> questionList) {
		ListSocialStudiesLoad.questionList = questionList;
	}
}
