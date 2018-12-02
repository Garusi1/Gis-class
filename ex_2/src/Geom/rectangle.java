/*
 * 
 */
package Geom;

// TODO: Auto-generated Javadoc
/**
 * The Class rectangle.
 *
 * @author mgaru
 * this class represents rectangle
 */
/**
 * @author mgaru
 *
 */
public class rectangle {

/** center - rectangle center x - width y - length. */
	

	private Point3D center;
	
	/** The y. */
	private double x,y;
	
	/**
	 * constructor.
	 *
	 * @param p the p
	 * @param x1 the x 1
	 * @param y1 the y 1
	 */
	
	
	public rectangle(Point3D p, double x1, double y1) {
		center = p;
		x = x1;
		y=y1;
	}
	
	/**
	 * gets functions.
	 *
	 * @return the center
	 */
	
	public Point3D getcenter() {
		return center;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getx() {
		return x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double gety() {
		return y;
	}
	
}
