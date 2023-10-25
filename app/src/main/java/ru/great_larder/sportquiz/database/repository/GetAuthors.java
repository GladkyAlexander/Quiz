package ru.great_larder.sportquiz.database.repository;

import android.content.Context;
import ru.great_larder.sportquiz.domain.Author;

import java.util.List;

public interface GetAuthors {
    List<Author> getAuthors(Context context);
}
