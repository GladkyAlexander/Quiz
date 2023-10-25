package ru.great_larder.sportquiz.services.load;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import org.jetbrains.annotations.NotNull;
import ru.great_larder.sportquiz.database.CompareQuestions;

public class LoadDataAppServiceLocal extends Worker {
    
    private final Context context;
    
    public LoadDataAppServiceLocal(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }
    
    @NonNull
    @NotNull
    @Override
    public Result doWork() {
        CompareQuestions compareQuestions = new CompareQuestions(context);
        compareQuestions.compare(null);
        return Result.success();
    }
}
