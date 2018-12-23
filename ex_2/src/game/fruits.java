package game;

import Geom.Point3D;


// TODO: Auto-generated Javadoc
/**
 * Fruit class- class thar represent object type of fruit.
 *
 * @author Naor Eliav and Michael Garusi
 * The class contains some fields: Point3D, general id that counts the number of friuts.
 */
public class fruits {
	
	/** The fruit point. */
	private Point3D fruitPoint;
	
	/** The on off. */
	private int onOff; // 1 is on and 0 is off
	
	/** The general id. */
	private static int generalId=0;
	
	/** The id. */
	private int id;
	
	/**
	 * constructor that get point3d.
	 *
	 * @param p the p
	 */
	public fruits(Point3D p) {
		fruitPoint= new Point3D(p);
		onOff = 1;
		id = generalId;
		generalId++;
	}
	
	/**
	 * default constructor.
	 */
	public fruits() {
		onOff = 1;	
		id = generalId;
		generalId++;

	}
	
	/**
	 * constructor that gets cordinates.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public fruits(double x, double y, double z) {
		fruitPoint= new Point3D(x,y,z) ;
		onOff = 1;	
		id = generalId;
		generalId++;

	}

	
	/**
	 * Sets the off.
	 */
	public void setOff() {
		onOff = 0;	
	}
	
	/**
	 * Gets the point.
	 *
	 * @return the point of the fruit
	 */
	public Point3D getPoint() {
		return fruitPoint;
	
	}
	
	/**
	 * Gets the on off.
	 *
	 * @return the on off
	 */
	public int getOnOff() {
		return onOff;
	}
	
	/**
	 * print the fruit.
	 *
	 * @return string
	 */
	public String toString() {
		return (fruitPoint.toString()+id);
	}
	
	/**
	 * copy function that copy the values of one fruit to another fruit.
	 *
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