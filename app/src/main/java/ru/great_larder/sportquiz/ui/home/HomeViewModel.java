package ru.great_larder.sportquiz.ui.home;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ru.great_larder.sportquiz.GlobalLinkUser;
import ru.great_larder.sportquiz.services.CheckNetClass;
import ru.great_larder.sportquiz.services.load.LoadDataFromMySQLForSQLite;
import ru.great_larder.sportquiz.services.load.LoadDataFromSQLiteFolLocal;
import ru.great_larder.sportquiz.services.load.LoadDataPuzzlesSQLite;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }
    
    public LiveData<String> getText() {
        return mText;
    }
    
    public void loadData(Context context, ProgressBar progressBarExternal){
        new Handler(Looper.getMainLooper()).postDelayed(()-> loPuzzl(context), 2000);
        new Handler(Looper.getMainLooper()).postDelayed(()-> loQuiz(context), 3000);
        new Handler(Looper.getMainLooper()).postDelayed(()-> loExtern(context, progressBarExternal), 4000);
    }
    
    private void loExtern(Context context, ProgressBar progressBarExternal) {
        if(GlobalLinkUser.getUser() != null) {
            if (new CheckNetClass().getConnectionType(context) != 0) {
                progressBarExternal.setVisibility(View.VISIBLE);
                progressBarExternal.setIndeterminate(true);
                new LoadDataFromMySQLForSQLite().load(GlobalLinkUser.getUser(), context, progressBarExternal);
            } else Toast.makeText(context, "Нет интернета!", Toast.LENGTH_LONG).show();
        } else Toast.makeText(context, "Зарегистрируйтесь", Toast.LENGTH_LONG).show();
    }
    
    private void loPuzzl(Context context) {
        new LoadDataPuzzlesSQLite().load(context);
    }
    
    private void loQuiz(Context context) {
        new LoadDataFromSQLiteFolLocal().load(context);
    }
    
}