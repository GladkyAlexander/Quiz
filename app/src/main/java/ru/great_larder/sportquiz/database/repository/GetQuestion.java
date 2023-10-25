package ru.great_larder.sportquiz.database.repository;

import android.content.Context;
import ru.great_larder.sportquiz.domain.Question;

import java.util.List;

public interface GetQuestion {
    List<Question> getListQuestion(Context context, String nameQuiz, String nameCity);
}
