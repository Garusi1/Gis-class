package game_Solution;

import java.util.ArrayList;

import game.Game;
// TODO: Auto-generated Javadoc
/**
 * This class represen object type of solution.
 * This class contains array list of paths. any path contains the points of the way of the game solution.
 * it also contains object type game.
 * @author naor eliav and michael garusi
 *
 */

public class Solution {

	/** The solution. */
	private ArrayList<Path> solution;
	
	/** The game. */
	private Game game;

	/**
	 * default constructor.
	 */
	public Solution() {
		solution = new ArrayList<Path>();
 	}
	
	/**
	 * constructor that get path.
	 *
	 * @param path the path
	 */
	
	public void add(Path path) {
		solution.add(path);
	}
	
	/**
	 * this class return the size of the path list.
	 *
	 * @return the size of the path list
	 */
	public int size() {
		return solution.size();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return null;

	}
	
	/**
	 * return the path at index num.
	 *
	 * @param num the num
	 * @return the path at index num
	 */
	public Path getPath(int num) {
		return solution.get(num);
	}
	
	/**
	 * retuen the fame of the solution.
	 *
	 * @return the fame of the solution
	 */
	public Game getGame() {
		return game;
	}
	
	/**
	 * this function get game and set it.
	 *
	 * @param game1 the new game
	 */
	public void setGame(Game game1) {
		game = game1;
	}
	
	/**
	 * this function clear the list of the path.
	 */
	public void clearSolution() {
		solution.clear();
	}
	
	
}