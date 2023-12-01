package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionRoadTransport;

import java.util.List;

public class ListRoadTransportLoad {
	private static List<QuestionRoadTransport> questionList;
	
	public static List<QuestionRoadTransport> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionRoadTransport> questionList) {
		ListRoadTransportLoad.questionList = questionList;
	}
}
