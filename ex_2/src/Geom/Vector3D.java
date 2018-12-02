/*
 * Copyright (c) 2016 Martin Davis.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 *
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package Geom;

// TODO: Auto-generated Javadoc
/**
 * Represents a vector in 3-dimensional Cartesian space.
 * 
 * @author mdavis
 *
 */
public class Vector3D {
	
	/**
	 * Computes the dot product of the 3D vectors AB and CD.
	 *
	 * @param A the a
	 * @param B the b
	 * @param C the c
	 * @param D the d
	 * @return the dot product
	 */
	public static double dot(Point3D A, Point3D B, Point3D C, Point3D D)
	{
		double ABx = B.x() - A.x();
		double ABy = B.y() - A.y();
		double ABz = B.z() - A.z();
		double CDx = D.x() - C.x();
		double CDy = D.y() - C.y();
		double CDz = D.z() - C.z();
		return ABx*CDx + ABy*CDy + ABz*CDz;
	}

	/**
	 * Creates a new vector with given X and Y components.
	 * 
	 * @param x
	 *            the x component
	 * @param y
	 *            the y component
	 * @param z
	 *            the z component
	 * @return a new vector
	 */
	public static Vector3D create(double x, double y, double z) {
		return new Vector3D(x, y, z);
	}

	/**
	 * Creates a vector from a {@link Point3D}.
	 * 
	 * @param coord
	 *            the Point3D to copy
	 * @return a new vector
	 */
	public static Vector3D create(Point3D coord) {
		return new Vector3D(coord);
	}

	/**
	 * Instantiates a new vector 3 D.
	 *
	 * @param v the v
	 */
	public Vector3D(Point3D v) {
		x = v.x();
		y = v.y();
		z = v.z();
	}

	/**
	 * Computes the 3D dot-product of two {@link Point3D}s.
	 * 
   * @param v1 the first vector
   * @param v2 the second vector
	 * @return the dot product of the vectors
	 */
	public static double dot(Point3D v1, Point3D v2) {
		return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z();
	}

	/** The x. */
	private double x;
	
	/** The y. */
	private double y;
	
	/** The z. */
	private double z;

	/**
	 * Instantiates a new vector 3 D.
	 *
	 * @param from the from
	 * @param to the to
	 */
	public Vector3D(Point3D from, Point3D to) {
		x = to.x() - from.x();
		y = to.y() - from.y();
		z = to.z() - from.z();
	}

	/**
	 * Instantiates a new vector 3 D.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Z.
	 *
	 * @return the double
	 */
	public double z() {
		return z;
	}


	/**
	 * Computes the dot-product of two vectors.
	 *
	 * @param v            a vector
	 * @return the dot product of the vectors
	 */
	public double dot(Vector3D v) {
		return x * v.x + y * v.y + z * v.z;
	}

	/**
	 * Length.
	 *
	 * @return the double
	 */
	public double length() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Length.
	 *
	 * @param v the v
	 * @return the double
	 */
	public static double length(Point3D v) {
		return Math.sqrt(v.x() * v.x() + v.y() * v.y() + v.z() * v.z());
	}

	/**
	 * Normalize.
	 *
	 * @return the vector 3 D
	 */
	public Vector3D normalize() {
		double length = length();
		if (length > 0.0)
			return divide(length());
		return create(0.0, 0.0, 0.0);
	}

	/**
	 * Divide.
	 *
	 * @param d the d
	 * @return the vector 3 D
	 */
	private Vector3D divide(double d) {
		return create(x / d, y / d, z / d);
	}

	/**
	 * Normalize.
	 *
	 * @param v the v
	 * @return the point 3 D
	 */
	public static Point3D normalize(Point3D v) {
		double len = length(v);
		return new Point3D(v.x() / len, v.y() / len, v.z() / len);
	}
	  
  	/**
  	 * Gets a string representation of this vector.
  	 *
  	 * @return a string representing this vector
  	 */
		public String toString() {
			return "[" + x + ", " + y + ", " + z + "]";
		}
		

}
