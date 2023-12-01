package ru.great_larder.sportquiz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.Toast;
import ru.great_larder.sportquiz.services.CheckNetClass;
import ru.great_larder.sportquiz.services.load.LoadDataFromMySQLForSQLite;
import ru.great_larder.sportquiz.services.load.LoadDataFromSQLiteFolLocal;

public class StartAppData {
	public void loadData(Context context){
		new Handler(Looper.getMainLooper()).postDelayed(()-> loQuiz(context), 1500);
		new Handler(Looper.getMainLooper()).postDelayed(()-> loExtern(context, GlobalLinkUser.getMainActivity().getProgressBar()), 2000);
	}
	
	private void loExtern(Context context, ProgressBar progressBarExternal) {
		if(GlobalLinkUser.getUser() != null) {
			if (new CheckNetClass().getConnectionType(context) == 0) {
				Toast.makeText(context, "Нет интернета!", Toast.LENGTH_LONG).show();
			}
			if (new CheckNetClass().getConnectionType(context) == 1) {
				Toast.makeText(context, "У Вас интернет оператора! Перейдите на вкладку Информация", Toast.LENGTH_LONG).show();
			}
			if (new CheckNetClass().getConnectionType(context) == 2) {
				new CheckNetClass().isInternetAvailable().subscribe((hasInternet) -> {
					if(hasInternet) {
						progressBarExternal.setIndeterminate(true);
						new LoadDataFromMySQLForSQLite().load(GlobalLinkUser.getUser(), context, progressBarExternal);
					}else {
						Toast.makeText(context, "Проверьте подключение к интернету!", Toast.LENGTH_LONG).show();
					}
				});
			}
		} else Toast.makeText(context, "Зарегистрируйтесь", Toast.LENGTH_LONG).show();
	}
	
	private void loQuiz(Context context) {
		new LoadDataFromSQLiteFolLocal().load(context);
	}
}
