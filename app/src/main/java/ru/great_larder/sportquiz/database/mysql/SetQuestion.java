package ru.great_larder.sportquiz.database.mysql;

import android.content.Context;
import ru.great_larder.sportquiz.domain.Question;
import ru.great_larder.sportquiz.domain.QuestionCity;
import ru.great_larder.sportquiz.domain.User;

import java.sql.SQLException;

public interface SetQuestion {
    Integer setQuestion(User user, Context context, Question question);
}
