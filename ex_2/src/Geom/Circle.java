package Geom;

import java.io.Serializable;

import Coords.MyCoords;

/**
 * this class represents a simple circle. <br />
 * it is used by the Delaunay Triangulation class. <br />
 * <br />
 * note that this class is immutable.
 * 
 * @see DelaunayTriangulation
 */
@SuppressWarnings("serial")
public class Circle implements Geom_element, Serializable {

	private Point3D center;
	private double radius;

	/**
	 * Constructor. <br />
	 * Constructs a new Circle
	 * 
	 * @param c
	 *            Center of the circle.
	 * @param r
	 *            Radius of the circle.
	 */
	public Circle(Point3D c, double r) {
		this.center = c;
		this.radius = r;
	}

	/**
	 * Copy Constructor. <br />
	 * Creates a new Circle with same properties of <code>circ</code>.
	 * 
	 * @param circ
	 *            Circle to clone.
	 */
	public Circle(Circle circ) {
		this.center = circ.center;
		this.radius = circ.radius;
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + ", raduis=" + radius + "]";
	}

	/**
	 * Gets the center of the circle.
	 * 
	 * @return the center of the circle.
	 */
	public Point3D center() {
		return this.center;
	}

	/**
	 * Gets the radius of the circle.
	 * 
	 * @return the radius of the circle.
	 */
	public double radius() {
		return this.radius;
	}
	

	public boolean isInside(Circle c) {
		MyCoords mc = new MyCoords();
		if (this.center.distance2D(c.center)>this.radius)
			return false;
		
		return true;
}
	public boolean AllInside(Circle c) {
		MyCoords mc = new MyCoords();
		if (this.center.distance2D(c.center)>this.radius-c.radius)
			return false;
		
		return true;
}

}
