package ru.great_larder.sportquiz.services.puzzle;

import ru.great_larder.sportquiz.domain.Puzzle;

import java.util.List;

public interface GetPuzzles {
    Puzzle getPuzzleById(int id);
    List<Puzzle> getListPuzzles();
}
