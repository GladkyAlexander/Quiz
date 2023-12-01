package ru.great_larder.sportquiz.domain;

public class QuestionAviationTransport extends Question{
	public QuestionAviationTransport(Integer id, String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String link, int level) {
		super(id, question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, link, level);
	}
	
	public QuestionAviationTransport() {
	}
	
	@Override
	public String toString() {
		return "QuestionAviationTransport{" +
				       "id=" + id +
				       ", question='" + question + '\'' +
				       ", rightAnswer='" + rightAnswer + '\'' +
				       ", wrongAnswer1='" + wrongAnswer1 + '\'' +
				       ", wrongAnswer2='" + wrongAnswer2 + '\'' +
				       ", wrongAnswer3='" + wrongAnswer3 + '\'' +
				       ", link='" + link + '\'' +
				       ", level=" + level +
				       '}';
	}
}
