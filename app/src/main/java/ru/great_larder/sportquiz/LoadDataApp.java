package ru.great_larder.sportquiz;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import ru.great_larder.sportquiz.database.FairiesDatabaseAdapter;
import ru.great_larder.sportquiz.database.PuzzleDatabaseAdapter;
import ru.great_larder.sportquiz.domain.Fairies;
import ru.great_larder.sportquiz.domain.Puzzle;
import ru.great_larder.sportquiz.services.fairies.GetFairies;
import ru.great_larder.sportquiz.services.fairies.GetFairiesImpl;
import ru.great_larder.sportquiz.services.puzzle.GetPuzzles;
import ru.great_larder.sportquiz.services.puzzle.GetPuzzlesImpl;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadDataApp {
    PuzzleDatabaseAdapter puzzleDatabaseAdapter;
    FairiesDatabaseAdapter fairiesDatabaseAdapter;
    
    public LoadDataApp(Context context) {
        puzzleDatabaseAdapter = new PuzzleDatabaseAdapter(context);
        fairiesDatabaseAdapter = new FairiesDatabaseAdapter(context);
    }
    
    public void setPuzzle() {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            
            List<Puzzle> listPuzzle;
            puzzleDatabaseAdapter.open();
            listPuzzle = puzzleDatabaseAdapter.getPuzzles();
            puzzleDatabaseAdapter.close();
            GetPuzzles getPuzzles = new GetPuzzlesImpl();
            List<Puzzle> listLocal = getPuzzles.getListPuzzles();
            
            handler.post(() -> {
                if (listPuzzle.isEmpty()) {
                    for (Puzzle h : listLocal) {
                        puzzleDatabaseAdapter.open();
                        h.setId_user((int) GlobalLinkUser.getUser().getId());
                        puzzleDatabaseAdapter.insert(h);
                        puzzleDatabaseAdapter.close();
                    }
                } else if (listPuzzle.size() < listLocal.size()) {
                    for (Puzzle d : listLocal) {
                        for (Puzzle f : listPuzzle) {
                            if (!Objects.equals(d.getId(), f.getId())) {
                                d.setId_user((int) GlobalLinkUser.getUser().getId());
                                puzzleDatabaseAdapter.open();
                                puzzleDatabaseAdapter.insert(d);
                                puzzleDatabaseAdapter.close();
                            }
                        }
                    }
                }
            });
            
        });
    }
    
    public void setFairies() {
        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            
            List<Fairies> list;
            fairiesDatabaseAdapter.open();
            list = fairiesDatabaseAdapter.getFairies();
            fairiesDatabaseAdapter.close();
            GetFairies getFairies = new GetFairiesImpl();
            List<Fairies> listLocal = getFairies.getListFairies();
            
            handler.post(() -> {
                if (list.isEmpty()) {
                    for (Fairies h : listLocal) {
                        h.setIdUser((int) GlobalLinkUser.getUser().getId());
                        fairiesDatabaseAdapter.open();
                        fairiesDatabaseAdapter.insert(h);
                        fairiesDatabaseAdapter.close();
                    }
                } else if (list.size() < listLocal.size()) {
                    for (Fairies floc : listLocal) {
                        for (Fairies fDB : list) {
                            if (!Objects.equals(floc.getId(), fDB.getId())) {
                                floc.setIdUser((int) GlobalLinkUser.getUser().getId());
                                fairiesDatabaseAdapter.open();
                                fairiesDatabaseAdapter.insert(floc);
                                fairiesDatabaseAdapter.close();
                            }
                        }
                    }
                }
            });
            
        });
    }
}
