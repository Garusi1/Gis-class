package ex_3;

import java.util.ArrayList;

public class Solution {

	private ArrayList<Path> solution;
	
	
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
	
}
