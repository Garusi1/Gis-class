package ex_3;

import java.util.ArrayList;

public class Game {
	private ArrayList<packman> packmanList;
	private ArrayList<fruits> FruitList;
	
	public Game() {
		packmanList = new ArrayList<packman>();
		FruitList = new ArrayList<fruits>();
	}
	public Game(ArrayList<packman> packmanList1, ArrayList<fruits> FruitList1) {
		packmanList = new ArrayList<packman>();
		packmanList = packmanList1;
		FruitList = new ArrayList<fruits>();
		FruitList=FruitList1;	
	}

	public int size() {
		return(packmanList.size()+FruitList.size());
	}
	
public ArrayList<fruits> getFruitList() {
	return FruitList;
}
public ArrayList<packman> getPackmanList() {
	return packmanList;
}
}
