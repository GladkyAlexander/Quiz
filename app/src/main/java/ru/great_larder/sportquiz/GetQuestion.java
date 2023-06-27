package ru.great_larder.sportquiz;

import ru.great_larder.sportquiz.domain.Question;

import java.util.List;

public interface GetQuestion {
    List<Question> getListQuestion(String value);
    Question getRandomQuestion(String value);
}
