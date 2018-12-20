package game;

import Geom.Point3D;


/**
 * Fruit class- class thar represent object type of fruit
 * @author Naor Eliav and Michael Garusi
 *The class contains some fields: Point3D, general id that counts the number of friuts.
 *
 */
public class fruits {
	private Point3D fruitPoint;
	private int onOff; // 1 is on and 0 is off
	private static int generalId=0;
	private int id;
	
	/**
	 * constructor that get point3d
	 * @param p- point3d
	 */
	public fruits(Point3D p) {
		fruitPoint= new Point3D(p);
		onOff = 1;
		id = generalId;
		generalId++;
	}
	/**
	 * default constructor
	 */
	public fruits() {
		onOff = 1;	
		id = generalId;
		generalId++;

	}
	
	/**
	 * constructor that gets cordinates
	 * @param x-x cordinate
	 * @param y-y cordinate
	 * @param z-z cordinate
	 */
	public fruits(double x, double y, double z) {
		fruitPoint= new Point3D(x,y,z) ;
		onOff = 1;	
		id = generalId;
		generalId++;

	}

	
	public void setOff() {
		onOff = 0;	
	}
	/**
	 * 
	 * @return the point of the fruit
	 */
	public Point3D getPoint() {
		return fruitPoint;
	
	}
	public int getOnOff() {
		return onOff;
	}
	/**
	 * print the fruit
	 * @return string
	 */
	public String toString() {
		return (fruitPoint.toString()+id);
	}
	/**
	 * copy function that copy the values of one fruit to another fruit
	 * @return fruit
	 */
	public fruits copy() {
		fruits f = new fruits();
		f.fruitPoint = fruitPoint;
		f.id = id;
		f.onOff = onOff;
		
		return f;
	}
	
	

}