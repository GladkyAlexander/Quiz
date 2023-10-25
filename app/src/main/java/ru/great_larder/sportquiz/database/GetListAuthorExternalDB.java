package ru.great_larder.sportquiz.database;

import android.content.Context;
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.domain.User;

import java.util.List;

public interface GetListAuthorExternalDB {
    List<Author> getListAuthor(User user, Context context);
}
