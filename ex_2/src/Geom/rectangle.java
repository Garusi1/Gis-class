package Geom;

/**
 * @author mgaru
 *this class represents rectangle
 */
/**
 * @author mgaru
 *
 */
public class rectangle {
/**
 * center - rectangle center
 * x - width
 * y - length
 **/
	

	private Point3D center;
	private double x,y;
	
	/**
	 * constructor
	 *
	 */
	
	
	public rectangle(Point3D p, double x1, double y1) {
		center = p;
		x = x1;
		y=y1;
	}
	
	/**
	 * gets functions
	 *
	 */
	
	public Point3D getcenter() {
		return center;
	}
	public double getx() {
		return x;
	}
	public double gety() {
		return y;
	}
	
}
