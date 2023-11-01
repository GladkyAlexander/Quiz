package ru.great_larder.sportquiz.services.load;

import android.content.Context;
import ru.great_larder.sportquiz.database.repository.get_live.ListPuzzlesLoad;
import ru.great_larder.sportquiz.database.sqlite.adapter_sqlite.PuzzleDatabaseAdapterSQLite;
import ru.great_larder.sportquiz.domain.Puzzle;
import ru.great_larder.sportquiz.services.puzzle.GetPuzzles;
import ru.great_larder.sportquiz.services.puzzle.GetPuzzlesImpl;
import rx.Single;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.List;

public class LoadDataPuzzlesSQLite {
	private Context context;
	
	public void load(Context context){
		this.context = context;
		Single.fromCallable(this::loadInBackgroundPuzzles)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::updateUiPuzzles);
	}
	
	private void updateUiPuzzles(List<Puzzle> resultObject) {
		ListPuzzlesLoad.setPuzzles(resultObject);
	}
	
	private List<Puzzle> loadInBackgroundPuzzles() {
		PuzzleDatabaseAdapterSQLite puzzleDatabaseAdapter = new PuzzleDatabaseAdapterSQLite(context);
		List<Puzzle> listPuzzle;
		puzzleDatabaseAdapter.open();
		listPuzzle = puzzleDatabaseAdapter.getPuzzles();
		puzzleDatabaseAdapter.close();
		
		if(listPuzzle != null && listPuzzle.isEmpty()){
			GetPuzzles getPuzzles = new GetPuzzlesImpl();
			return getPuzzles.getListPuzzles();
		}
		
		return listPuzzle;
	}
}
