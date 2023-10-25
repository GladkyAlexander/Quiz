package ru.great_larder.sportquiz.database.repository.impl;

import android.content.Context;
import ru.great_larder.sportquiz.database.repository.GetAuthors;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.AuthorAdapterSQLite;
import ru.great_larder.sportquiz.domain.Author;

import java.util.ArrayList;
import java.util.List;

public class GetAuthorImpl implements GetAuthors {
    @Override
    public List<Author> getAuthors(Context context) {
        AuthorAdapterSQLite authorAdapterSQLite = new AuthorAdapterSQLite(context);
        authorAdapterSQLite.open();
        List<Author> questionAuthor = new ArrayList<>(authorAdapterSQLite.getAuthors());
        authorAdapterSQLite.close();
        return questionAuthor;
    }
}
