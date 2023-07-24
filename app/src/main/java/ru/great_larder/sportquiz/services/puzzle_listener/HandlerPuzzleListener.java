package ru.great_larder.sportquiz.services.puzzle_listener;

import java.util.HashSet;
import java.util.Set;

public class HandlerPuzzleListener implements SubjectPuzzle {

    private DataPuzzle dataPuzzle;
    private final Set<ObserverPuzzle> observerPuzzle = new HashSet<>();

    public DataPuzzle getDataPuzzle(){
        return dataPuzzle;
    }
    public void onNewDataPuzzle(DataPuzzle newDataPuzzle){
        this.dataPuzzle = newDataPuzzle;
        notifyObserversPuzzle();
    }

    @Override
    public void registerObserverPuzzle(ObserverPuzzle observerPuzzle) {
        this.observerPuzzle.add(observerPuzzle);
    }

    @Override
    public void unregisterObserverPuzzle(ObserverPuzzle observerPuzzle) {
        this.observerPuzzle.remove(observerPuzzle);
    }

    @Override
    public void notifyObserversPuzzle() {
        for(ObserverPuzzle observerPuzzle : observerPuzzle){
            observerPuzzle.updatePuzzle(dataPuzzle);
        }
    }

    @Override
    public void clear() {
        this.observerPuzzle.clear();
    }

    @Override
    public Set<ObserverPuzzle> getOU() {
        return observerPuzzle;
    }
}
