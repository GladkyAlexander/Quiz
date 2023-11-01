package ru.great_larder.sportquiz.database.repository.get_live;

import ru.great_larder.sportquiz.domain.Puzzle;

import java.util.List;

public class ListPuzzlesLoad {
	private static List<Puzzle> puzzles;
	
	public static List<Puzzle> getPuzzles() {
		return puzzles;
	}
	
	public static void setPuzzles(List<Puzzle> puzzles) {
		ListPuzzlesLoad.puzzles = puzzles;
	}
}
