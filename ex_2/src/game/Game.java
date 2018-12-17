package game;

import java.util.ArrayList;

import Geom.Point3D;

public class Game {
	private ArrayList<packman> packmanList;
	private ArrayList<fruits> FruitList;
	private double gameTime = 0;
	
	public Game() {
		packmanList = new ArrayList<packman>();
		FruitList = new ArrayList<fruits>();
		gameTime = 0;
	}
	public Game(ArrayList<packman> packmanList1, ArrayList<fruits> FruitList1) {
		packmanList = new ArrayList<packman>();
		packmanList = packmanList1;
		FruitList = new ArrayList<fruits>();
		FruitList=FruitList1;	
		gameTime = 0;
	}

	public int size() {
		return(packmanList.size()+FruitList.size());
	}
	public void setTime(double time1) {
		gameTime=time1;
	}
	
public ArrayList<fruits> getFruitList() {
	return FruitList;
}
public ArrayList<packman> getPackmanList() {
	return packmanList;
}

public Point3D getLocationByTime(double time) {
//	
//	if(time == 0 || time>game time) {
//		return his location		
//	}
//	else {
//		
//	}
	
	return null;
}
}
