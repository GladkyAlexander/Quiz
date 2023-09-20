package ru.great_larder.sportquiz.database;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import ru.great_larder.sportquiz.database.author_and_partners.ListLoadAuthor;
import ru.great_larder.sportquiz.database.mysql.GetListAuthor;
import ru.great_larder.sportquiz.database.mysql.request_mysql.GetListAuthorImpl;
import ru.great_larder.sportquiz.domain.Author;
import ru.great_larder.sportquiz.domain.User;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadAuthorAndPartnersToDBExternal {
    public LoadAuthorAndPartnersToDBExternal(User user, Context context) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            
            GetListAuthor getListAuthor = new GetListAuthorImpl();
            List<Author> authors = getListAuthor.getListAuthor(user, context);
            
            handler.post(() -> {
                ListLoadAuthor.setAuthors(authors);
            });
            
        });
    }
}
