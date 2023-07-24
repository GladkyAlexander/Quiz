package ru.great_larder.sportquiz.services.puzzle_listener;

import java.util.Set;

public interface SubjectPuzzle {
    void registerObserverPuzzle(ObserverPuzzle observerPuzzle);
    void unregisterObserverPuzzle(ObserverPuzzle observerPuzzle);
    void notifyObserversPuzzle();
    void clear();
    Set<ObserverPuzzle> getOU();
}
