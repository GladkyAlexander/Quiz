package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.QuestionRailwayTransport;

import java.util.List;

public class ListRailwayTransportLoad {
	private static List<QuestionRailwayTransport> questionList;
	
	public static List<QuestionRailwayTransport> getQuestionList() {
		return questionList;
	}
	
	public static void setQuestionList(List<QuestionRailwayTransport> questionList) {
		ListRailwayTransportLoad.questionList = questionList;
	}
}
