package ru.great_larder.sportquiz.services.puzzle_listener;

import ru.great_larder.sportquiz.domain.Puzzle;

public class DataPuzzle {
    private final Puzzle puzzle;

    public DataPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    public Puzzle getPuzzle(){
        return puzzle;
    }

}
