package ru.great_larder.sportquiz.domain;

public class QuestionBashkirLanguage extends Question{
	public QuestionBashkirLanguage(Integer id, String question, String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, String link, int level) {
		super(id, question, rightAnswer, wrongAnswer1, wrongAnswer2, wrongAnswer3, link, level);
	}
	
	public QuestionBashkirLanguage() {
	}
	
	@Override
	public String toString() {
		return "QuestionBashkirlanguage{" +
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
