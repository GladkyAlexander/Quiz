package ru.great_larder.sportquiz.services.load;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.LoadDataApp;
import ru.great_larder.sportquiz.database.mysql.SetQuestion;
import ru.great_larder.sportquiz.database.mysql.request_set_mysql.SetQuestionMathematicsImpl;
import ru.great_larder.sportquiz.domain.QuestionMathematics;

public class LoadDataAppShop extends Worker {
    private final Context context;
    
    public LoadDataAppShop(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }
    
    @NonNull
    @NotNull
    @Override
    public Result doWork() {
        
        LoadDataApp loadDataApp = new LoadDataApp(context);
        loadDataApp.setFairies();
        loadDataApp.setPuzzle();
        
        return Result.success();
    }
}
