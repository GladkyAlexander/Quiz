package ru.great_larder.sportquiz.database.mysql;

import android.content.Context;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;

import java.util.List;

public interface GetListQuestionMySQL {
    List<Question> getListQuestion(User user, Context context);
}
