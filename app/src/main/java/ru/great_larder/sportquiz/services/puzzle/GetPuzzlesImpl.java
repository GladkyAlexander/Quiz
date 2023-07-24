package ru.great_larder.sportquiz.services.puzzle;

import ru.great_larder.sportquiz.R;
import ru.great_larder.sportquiz.domain.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetPuzzlesImpl implements GetPuzzles{
    @Override
    public Puzzle getPuzzleById(int id) {
        for (Puzzle p : getListPuzzles()){
            if(Objects.equals(id, p.getId())){
                return p;
            }
        }
        return null;
    }
    
    @Override
    public List<Puzzle> getListPuzzles() {
        List<Puzzle> puzzles = new ArrayList<>();
        puzzles.add(new Puzzle(1, R.drawable.puz1, 0, 5, false, 5, false, 5, false, 5, false, 5, false
            , 10, false, 15, false, 10, false, 5, false, 5, false, 15, false, 5, false, 10, false
            , 15, false, 10, false, 5, false, 5, false, 10, false, 15, false, 10, false, 5, false
            , 5, false, 10, false, 15, false, 10, false, 5, false, 5, false, 5, false, 5, false
            , 5, false));
        puzzles.add(new Puzzle(2, R.drawable.puz2, 0, 5, false, 5, false, 5, false, 5, false, 5, false
            , 10, false, 15, false, 10, false, 5, false, 5, false, 15, false, 5, false, 10, false
            , 15, false, 10, false, 5, false, 5, false, 10, false, 15, false, 10, false, 5, false
            , 5, false, 10, false, 15, false, 10, false, 5, false, 5, false, 5, false, 5, false
            , 5, false));
        puzzles.add(new Puzzle(3, R.drawable.puz3, 0, 5, false, 5, false, 5, false, 5, false, 5, false
            , 10, false, 15, false, 10, false, 5, false, 5, false, 15, false, 5, false, 10, false
            , 15, false, 10, false, 5, false, 5, false, 10, false, 15, false, 10, false, 5, false
            , 5, false, 10, false, 15, false, 10, false, 5, false, 5, false, 5, false, 5, false
            , 5, false));
        puzzles.add(new Puzzle(4, R.drawable.puz4, 0, 5, false, 5, false, 5, false, 5, false, 5, false
            , 10, false, 15, false, 10, false, 5, false, 5, false, 15, false, 5, false, 10, false
            , 15, false, 10, false, 5, false, 5, false, 10, false, 15, false, 10, false, 5, false
            , 5, false, 10, false, 15, false, 10, false, 5, false, 5, false, 5, false, 5, false
            , 5, false));
        puzzles.add(new Puzzle(5, R.drawable.puz5, 0, 5, false, 5, false, 5, false, 5, false, 5, false
            , 10, false, 15, false, 10, false, 5, false, 5, false, 15, false, 5, false, 10, false
            , 15, false, 10, false, 5, false, 5, false, 10, false, 15, false, 10, false, 5, false
            , 5, false, 10, false, 15, false, 10, false, 5, false, 5, false, 5, false, 5, false
            , 5, false));
        return puzzles;
    }
}
