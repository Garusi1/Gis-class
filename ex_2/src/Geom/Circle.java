/*
 * 
 */
package Geom;

import java.io.Serializable;

import Coords.MyCoords;

// TODO: Auto-generated Javadoc
/**
 * this class represents a simple circle.
 */
@SuppressWarnings("serial")
public class Circle implements Geom_element, Serializable {

	/** The center. */
	private Point3D center;
	
	/** The radius. */
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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
	

	/**
	 * Checks if is inside.
	 *
	 * @param c the c
	 * @return true, if is inside
	 */
	public boolean isInside(Circle c) {
		MyCoords mc = new MyCoords();
		if (this.center.distance2D(c.center)>this.radius)
			return false;
		
		return true;
}
	
	/**
	 * All inside.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean AllInside(Circle c) {
		MyCoords mc = new MyCoords();
		if (this.center.distance2D(c.center)>this.radius-c.radius)
			return false;
		
		return true;
}

	/* (non-Javadoc)
	 * @see Geom.Geom_element#distance3D(Geom.Point3D)
	 */
	@Override
	public double distance3D(Point3D p) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see Geom.Geom_element#distance2D(Geom.Point3D)
	 */
	@Override
	public double distance2D(Point3D p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
