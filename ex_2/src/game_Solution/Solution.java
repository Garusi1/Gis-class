package game_Solution;

import java.util.ArrayList;

import game.Game;

public class Solution {

	private ArrayList<Path> solution;
	private Game game;

	
	public Solution() {
		solution = new ArrayList<Path>();
 	}
	
	public void add(Path path) {
		solution.add(path);
	}
	public int size() {
		return solution.size();
	}
	
	public String toString() {
		return null;

	}
	public Path getPath(int num) {
		return solution.get(num);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game1) {
		game = game1;
	}
	
	public void clearSolution() {
		solution.clear();
	}
	
	
}
