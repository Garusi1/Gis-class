package game;

import java.util.ArrayList;

import Geom.Point3D;
// TODO: Auto-generated Javadoc
/**
 * This class represent object type of game.
 * the class fields are:
 * arraylist of packman
 * arraylist of fruit
 * and game time
 * @author Naor eliav and michael garusi
 *
 */

public class Game {
	
	/** The packman list. */
	private ArrayList<packman> packmanList;
	
	/** The Fruit list. */
	private ArrayList<fruits> FruitList;
	
	/** The game time. */
	private double gameTime = 0;
	
	/**
	 * default constructor.
	 */
	public Game() {
		packmanList = new ArrayList<packman>();
		FruitList = new ArrayList<fruits>();
		gameTime = 0;
	}
	
	/**
	 * constructor that get packman list and fruit list.
	 *
	 * @param packmanList1 the packman list 1
	 * @param FruitList1 the fruit list 1
	 */
	public Game(ArrayList<packman> packmanList1, ArrayList<fruits> FruitList1) {
		packmanList = new ArrayList<packman>();
		packmanList = packmanList1;
		FruitList = new ArrayList<fruits>();
		FruitList=FruitList1;	
		gameTime = 0;
	}
/**
 * Function that return the size of the pacman list + the size of fruit list.
 * @return the size of the pacman list + the size of fruit list.
 */
	public int size() {
		return(packmanList.size()+FruitList.size());
	}
	
	/**
	 * this function get time and set it.
	 *
	 * @param time1 the new time
	 */
	public void setTime(double time1) {
		gameTime=time1;
	}
	
	/**
	 * This function returns the fruitlist.
	 *
	 * @return fruitlist.
	 */
public ArrayList<fruits> getFruitList() {
	return FruitList;
}

/**
 * This function returns the packmanlist.
 *
 * @return packman list.
 */
public ArrayList<packman> getPackmanList() {
	return packmanList;
}

/**
 * this function get packlist and fruitlist and set it.
 *
 * @param fru the fru
 * @param pack the pack
 */
public void set(ArrayList<fruits> fru, ArrayList<packman> pack) {
	packmanList = pack;
	FruitList = fru;
	
}

/**
 * Gets the location by time.
 *
 * @param time the time
 * @return the location by time
 */
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