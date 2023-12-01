package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionAviationTransport;

import java.util.List;

public class ListAviationTransportLoad {
	private static List<QuestionAviationTransport> questionList;
	
	public static List<QuestionAviationTransport> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionAviationTransport> questionList) {
		ListAviationTransportLoad.questionList = questionList;
	}
}
