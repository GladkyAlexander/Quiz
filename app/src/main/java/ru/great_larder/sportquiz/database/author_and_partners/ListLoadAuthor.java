package ru.great_larder.sportquiz.database.author_and_partners;

import ru.great_larder.sportquiz.domain.Author;

import java.util.List;

public class ListLoadAuthor {
    private static List<Author> authors;
    
    public static List<Author> getAuthors() {
        return authors;
    }
    
    public static void setAuthors(List<Author> authors) {
        ListLoadAuthor.authors = authors;
    }
}
