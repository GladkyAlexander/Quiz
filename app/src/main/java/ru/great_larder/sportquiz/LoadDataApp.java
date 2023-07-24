package ru.great_larder.sportquiz;

import android.content.Context;
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

public class LoadDataApp {
    PuzzleDatabaseAdapter puzzleDatabaseAdapter;
    FairiesDatabaseAdapter fairiesDatabaseAdapter;
    public LoadDataApp(Context context) {
        puzzleDatabaseAdapter = new PuzzleDatabaseAdapter(context);
        fairiesDatabaseAdapter = new FairiesDatabaseAdapter(context);
    }
    public void setPuzzle(){
        List<Puzzle> list;
        puzzleDatabaseAdapter.open();
        list = puzzleDatabaseAdapter.getPuzzles();
        puzzleDatabaseAdapter.close();
        GetPuzzles getPuzzles = new GetPuzzlesImpl();
        List<Puzzle> listLocal = getPuzzles.getListPuzzles();
        if(list.size() == 0){
            for (Puzzle h : listLocal){
                puzzleDatabaseAdapter.open();
                puzzleDatabaseAdapter.insert(h);
                puzzleDatabaseAdapter.close();
            }
        } else if(list.size() < listLocal.size()){
            for (Puzzle d : listLocal){
                for (Puzzle f : list){
                    if(!Objects.equals(d.getId(), f.getId())){
                        puzzleDatabaseAdapter.open();
                        puzzleDatabaseAdapter.insert(d);
                        puzzleDatabaseAdapter.close();
                    }
                }
            }
        }
    }
    public void setFairies(){
        List<Fairies> list;
        fairiesDatabaseAdapter.open();
        list = fairiesDatabaseAdapter.getFairies();
        fairiesDatabaseAdapter.close();
        GetFairies getFairies = new GetFairiesImpl();
        List<Fairies> listLocal = getFairies.getListFairies();
        if(list.size() == 0){
            for (Fairies h : listLocal){
                fairiesDatabaseAdapter.open();
                fairiesDatabaseAdapter.insert(h);
                fairiesDatabaseAdapter.close();
            }
        } else if(list.size() < listLocal.size()){
            for (Fairies floc : listLocal){
                for (Fairies fDB : list){
                    if(!Objects.equals(floc.getId(), fDB.getId())){
                        fairiesDatabaseAdapter.open();
                        fairiesDatabaseAdapter.insert(floc);
                        fairiesDatabaseAdapter.close();
                    }
                }
            }
        }
    }
}
