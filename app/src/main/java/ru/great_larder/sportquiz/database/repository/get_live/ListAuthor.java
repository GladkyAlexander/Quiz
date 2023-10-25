package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.Author;

import java.util.List;

public class ListAuthor {
    public static List<Author> getAuthorsList() {
        return authorsList;
    }
    
    public static void setAuthorsList(List<Author> authorsList) {
        ListAuthor.authorsList = authorsList;
    }
    
    private static List<Author> authorsList;
}
