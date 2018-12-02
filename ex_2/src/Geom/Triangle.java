/*
 * Copyright (c) 2016 Vivid Solutions.
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

import java.awt.Point;

import algorithms.Angle;

// TODO: Auto-generated Javadoc
/**
 * Represents a planar triangle, and provides methods for calculating various
 * properties of triangles.
 * 
 * @version 1.7
 */
public class Triangle extends Point3D implements Geom_element 
{

  

/**
 * Instantiates a new triangle.
 *
 * @param x the x
 * @param y the y
 * @param z the z
 */
public Triangle(double x, double y, double z) {
		super(x, y, z);
		// TODO Auto-generated constructor stub
	}

/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

/**
   * Tests whether a triangle is acute. A triangle is acute iff all interior
   * angles are acute. This is a strict test - right triangles will return
   * <tt>false</tt> A triangle which is not acute is either right or obtuse.
   * <p>
   * Note: this implementation is not robust for angles very close to 90
   * degrees.
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return true if the triangle is acute
   */
  public static boolean isAcute(Point3D a, Point3D b, Point3D c)
  {
    if (!Angle.isAcute(a, b, c))
      return false;
    if (!Angle.isAcute(b, c, a))
      return false;
    if (!Angle.isAcute(c, a, b))
      return false;
    return true;
  }

  /**
   * Computes the line which is the perpendicular bisector of the line segment
   * a-b.
   *
   * @param a          a point
   * @param b          another point
   * @param c the c
   * @return the perpendicular bisector, as an HPoint3D
   */
//  public static Point3D perpendicularBisector(Point3D a, Point3D b)
//  {
//    // returns the perpendicular bisector of the line segment ab
//    double dx = b.x() - a.x();
//    double dy = b.y() - a.y();
//    Point3D l1 = new Point3D(a.x() + dx / 2.0, a.y() + dy / 2.0, 1.0);
//    Point3D l2 = new Point3D(a.x() - dy + dx / 2.0, a.y() + dx + dy / 2.0,
//        1.0);
//    return new Point3D(l1, l2);
//  }

  /**
   * Computes the circumcentre of a triangle. The circumcentre is the centre of
   * the circumcircle, the smallest circle which encloses the triangle. It is
   * also the common intersection point of the perpendicular bisectors of the
   * sides of the triangle, and is the only point which has equal distance to
   * all three vertices of the triangle.
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the circumcentre of the triangle
   */
  /*
   * // original non-robust algorithm public static Point3D
   * circumcentre(Point3D a, Point3D b, Point3D c) { // compute the
   * perpendicular bisector of chord ab HPoint3D cab =
   * perpendicularBisector(a, b); // compute the perpendicular bisector of chord
   * bc HPoint3D cbc = perpendicularBisector(b, c); // compute the
   * intersection of the bisectors (circle radii) HPoint3D hcc = new
   * HPoint3D(cab, cbc); Point3D cc = null; try { cc = new
   * Point3D(hcc.getX(), hcc.getY()); } catch (NotRepresentableException ex)
   * { // MD - not sure what we can do to prevent this (robustness problem) //
   * Idea - can we condition which edges we choose? throw new
   * IllegalStateException(ex.getMessage()); }
   * 
   * //System.out.println("Acc = " + a.distance(cc) + ", Bcc = " +
   * b.distance(cc) + ", Ccc = " + c.distance(cc) );
   * 
   * return cc; }
   */

  /**
   * Computes the circumcentre of a triangle. The circumcentre is the centre of
   * the circumcircle, the smallest circle which encloses the triangle. It is
   * also the common intersection point of the perpendicular bisectors of the
   * sides of the triangle, and is the only point which has equal distance to
   * all three vertices of the triangle.
   * <p>
   * The circumcentre does not necessarily lie within the triangle. For example,
   * the circumcentre of an obtuse isosceles triangle lies outside the triangle.
   * <p>
   * This method uses an algorithm due to J.R.Shewchuk which uses normalization
   * to the origin to improve the accuracy of computation. (See <i>Lecture Notes
   * on Geometric Robustness</i>, Jonathan Richard Shewchuk, 1999).
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the circumcentre of the triangle
   */
  public static Point3D circumcentre(Point3D a, Point3D b, Point3D c)
  {
    double cx = c.x();
    double cy = c.y();
    double ax = a.x() - cx;
    double ay = a.y() - cy;
    double bx = b.x() - cx;
    double by = b.y() - cy;

    double denom = 2 * det(ax, ay, bx, by);
    double numx = det(ay, ax * ax + ay * ay, by, bx * bx + by * by);
    double numy = det(ax, ax * ax + ay * ay, bx, bx * bx + by * by);

    double ccx = cx - numx / denom;
    double ccy = cy + numy / denom;

    return new Point3D(ccx, ccy);
  }

  /**
   * Computes the determinant of a 2x2 matrix. Uses standard double-precision
   * arithmetic, so is susceptible to round-off error.
   * 
   * @param m00
   *          the [0,0] entry of the matrix
   * @param m01
   *          the [0,1] entry of the matrix
   * @param m10
   *          the [1,0] entry of the matrix
   * @param m11
   *          the [1,1] entry of the matrix
   * @return the determinant
   */
  private static double det(double m00, double m01, double m10, double m11)
  {
    return m00 * m11 - m01 * m10;
  }

  /**
   * Computes the incentre of a triangle. The <i>inCentre</i> of a triangle is
   * the point which is equidistant from the sides of the triangle. It is also
   * the point at which the bisectors of the triangle's angles meet. It is the
   * centre of the triangle's <i>incircle</i>, which is the unique circle that
   * is tangent to each of the triangle's three sides.
   * <p>
   * The incentre always lies within the triangle.
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the point which is the incentre of the triangle
   */
  public static Point3D inCentre(Point3D a, Point3D b, Point3D c)
  {
    // the lengths of the sides, labelled by their opposite vertex
    double len0 = b.distance3D(c);
    double len1 = a.distance3D(c);
    double len2 = a.distance3D(b);
    double circum = len0 + len1 + len2;

    double inCentreX = (len0 * a.x() + len1 * b.x() + len2 * c.x()) / circum;
    double inCentreY = (len0 * a.y() + len1 * b.y() + len2 * c.y()) / circum;
    return new Point3D(inCentreX, inCentreY);
  }

  /**
   * Computes the centroid (centre of mass) of a triangle. This is also the
   * point at which the triangle's three medians intersect (a triangle median is
   * the segment from a vertex of the triangle to the midpoint of the opposite
   * side). The centroid divides each median in a ratio of 2:1.
   * <p>
   * The centroid always lies within the triangle.
   * 
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the centroid of the triangle
   */
  public static Point3D centroid(Point3D a, Point3D b, Point3D c)
  {
    double x = (a.x() + b.x() + c.x()) / 3;
    double y = (a.y() + b.y() + c.y()) / 3;
    return new Point3D(x, y);
  }

  /**
   * Computes the length of the longest side of a triangle.
   *
   * @param a          a vertex of the triangle
   * @param b          a vertex of the triangle
   * @param c          a vertex of the triangle
   * @return the length of the longest side of the triangle
   */
  public static double longestSideLength(Point3D a, Point3D b,
      Point3D c)
  {
    double lenAB = a.distance3D(b);
    double lenBC = b.distance3D(c);
    double lenCA = c.distance3D(a);
    double maxLen = lenAB;
    if (lenBC > maxLen)
      maxLen = lenBC;
    if (lenCA > maxLen)
      maxLen = lenCA;
    return maxLen;
  }

  /**
   * Computes the point at which the bisector of the angle ABC cuts the segment
   * AC.
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the angle bisector cut point
   */
  public static Point3D angleBisector(Point3D a, Point3D b,
      Point3D c)
  {
    /**
     * Uses the fact that the lengths of the parts of the split segment are
     * proportional to the lengths of the adjacent triangle sides
     */
    double len0 = b.distance3D(a);
    double len2 = b.distance3D(c);
    double frac = len0 / (len0 + len2);
    double dx = c.x() - a.x();
    double dy = c.y() - a.y();

    Point3D splitPt = new Point3D(a.x() + frac * dx, a.y() + frac * dy);
    return splitPt;
  }

  /**
   * Computes the 2D area of a triangle. The area value is always non-negative.
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the area of the triangle
   * 
   * @see #signedArea(Point3D, Point3D, Point3D)
   */
  public static double area(Point3D a, Point3D b, Point3D c)
  {
    return Math
        .abs(((c.x() - a.x()) * (b.y() - a.y()) - (b.x() - a.x()) * (c.y() - a.y())) / 2);
  }

  /**
   * Computes the signed 2D area of a triangle. The area value is positive if
   * the triangle is oriented CW, and negative if it is oriented CCW.
   * <p>
   * The signed area value can be used to determine point orientation, but the
   * implementation in this method is susceptible to round-off errors. Use
   * {@link Orientation#index(Point3D, Point3D, Point3D)}
   * for robust orientation calculation.
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the signed 2D area of the triangle
   * 
   * @see Orientation#index(Point3D, Point3D, Point3D)
   */
  public static double signedArea(Point3D a, Point3D b, Point3D c)
  {
    /**
     * Uses the formula 1/2 * | u x v | where u,v are the side vectors of the
     * triangle x is the vector cross-product For 2D vectors, this formula
     * simplifies to the expression below
     */
    return ((c.x() - a.x()) * (b.y() - a.y()) - (b.x() - a.x()) * (c.y() - a.y())) / 2;
  }

  /**
   * Computes the 3D area of a triangle. The value computed is always
   * non-negative.
   * 
   * @param a
   *          a vertex of the triangle
   * @param b
   *          a vertex of the triangle
   * @param c
   *          a vertex of the triangle
   * @return the 3D area of the triangle
   */
  public static double area3D(Point3D a, Point3D b, Point3D c)
  {
    /**
     * Uses the formula 1/2 * | u x v | where u,v are the side vectors of the
     * triangle x is the vector cross-product
     */
    // side vectors u and v
    double ux = b.x() - a.x();
    double uy = b.y() - a.y();
    double uz = b.z() - a.z();

    double vx = c.x() - a.x();
    double vy = c.y() - a.y();
    double vz = c.z() - a.z();

    // cross-product = u x v
    double crossx = uy * vz - uz * vy;
    double crossy = uz * vx - ux * vz;
    double crossz = ux * vy - uy * vx;

    // tri area = 1/2 * | u x v |
    double absSq = crossx * crossx + crossy * crossy + crossz * crossz;
    double area3D = Math.sqrt(absSq) / 2;

    return area3D;
  }

  /**
   * Computes the Z-value (elevation) of an XY point on a three-dimensional
   * plane defined by a triangle whose vertices have Z-values. The defining
   * triangle must not be degenerate (in other words, the triangle must enclose
   * a non-zero area), and must not be parallel to the Z-axis.
   * <p>
   * This method can be used to interpolate the Z-value of a point inside a
   * triangle (for example, of a TIN facet with elevations on the vertices).
   * 
   * @param p
   *          the point to compute the Z-value of
   * @param v0
   *          a vertex of a triangle, with a Z ordinate
   * @param v1
   *          a vertex of a triangle, with a Z ordinate
   * @param v2
   *          a vertex of a triangle, with a Z ordinate
   * @return the computed Z-value (elevation) of the point
   */
  public static double interpolateZ(Point3D p, Point3D v0, Point3D v1,
      Point3D v2)
  {
    double x0 = v0.x();
    double y0 = v0.y();
    double a = v1.x() - x0;
    double b = v2.x() - x0;
    double c = v1.y() - y0;
    double d = v2.y() - y0;
    double det = a * d - b * c;
    double dx = p.x() - x0;
    double dy = p.y() - y0;
    double t = (d * dx - b * dy) / det;
    double u = (-c * dx + a * dy) / det;
    double z = v0.z() + t * (v1.z() - v0.z()) + u * (v2.z() - v0.z());
    return z;
  }

  /** The Point3Ds of the vertices of the triangle. */
  public Point3D p0, p1, p2;

  /**
   * Creates a new triangle with the given vertices.
   * 
   * @param p0
   *          a vertex
   * @param p1
   *          a vertex
   * @param p2
   *          a vertex
   */
  public void setTriangle (Point3D p0, Point3D p1, Point3D p2)
  {
    this.p0 = p0;
    this.p1 = p1;
    this.p2 = p2;
    
  }

  /**
   * Computes the incentre of this triangle. The <i>incentre</i> of a triangle
   * is the point which is equidistant from the sides of the triangle. It is
   * also the point at which the bisectors of the triangle's angles meet. It is
   * the centre of the triangle's <i>incircle</i>, which is the unique circle
   * that is tangent to each of the triangle's three sides.
   * 
   * @return the point which is the inCentre of this triangle
   */
  public Point3D inCentre()
  {
    return inCentre(p0, p1, p2);
  }

  /**
   * Tests whether this triangle is acute. A triangle is acute iff all interior
   * angles are acute. This is a strict test - right triangles will return
   * <tt>false</tt> A triangle which is not acute is either right or obtuse.
   * <p>
   * Note: this implementation is not robust for angles very close to 90
   * degrees.
   * 
   * @return true if this triangle is acute
   */
  public boolean isAcute()
  {
    return isAcute(this.p0, this.p1, this.p2);
  }

  /**
   * Computes the circumcentre of this triangle. The circumcentre is the centre
   * of the circumcircle, the smallest circle which encloses the triangle. It is
   * also the common intersection point of the perpendicular bisectors of the
   * sides of the triangle, and is the only point which has equal distance to
   * all three vertices of the triangle.
   * <p>
   * The circumcentre does not necessarily lie within the triangle.
   * <p>
   * This method uses an algorithm due to J.R.Shewchuk which uses normalization
   * to the origin to improve the accuracy of computation. (See <i>Lecture Notes
   * on Geometric Robustness</i>, Jonathan Richard Shewchuk, 1999).
   * 
   * @return the circumcentre of this triangle
   */
  public Point3D circumcentre()
  {
    return circumcentre(this.p0, this.p1, this.p2);
  }

  /**
   * Computes the centroid (centre of mass) of this triangle. This is also the
   * point at which the triangle's three medians intersect (a triangle median is
   * the segment from a vertex of the triangle to the midpoint of the opposite
   * side). The centroid divides each median in a ratio of 2:1.
   * <p>
   * The centroid always lies within the triangle.
   * 
   * @return the centroid of this triangle
   */
  public Point3D centroid()
  {
    return centroid(this.p0, this.p1, this.p2);
  }

  /**
   * Computes the length of the longest side of this triangle.
   *
   * @return the length of the longest side of this triangle
   */
  public double longestSideLength()
  {
    return longestSideLength(this.p0, this.p1, this.p2);
  }

  /**
   * Computes the 2D area of this triangle. The area value is always
   * non-negative.
   * 
   * @return the area of this triangle
   * 
   * @see #signedArea()
   */
  public double area()
  {
    return area(this.p0, this.p1, this.p2);
  }

  /**
   * Computes the signed 2D area of this triangle. The area value is positive if
   * the triangle is oriented CW, and negative if it is oriented CCW.
   * <p>
   * The signed area value can be used to determine point orientation, but the
   * implementation in this method is susceptible to round-off errors. Use
   * {@link Orientation#index(Point3D, Point3D, Point3D)}
   * for robust orientation calculation.
   * 
   * @return the signed 2D area of this triangle
   * 
   * @see Orientation#index(Point3D, Point3D, Point3D)
   */
  public double signedArea()
  {
    return signedArea(this.p0, this.p1, this.p2);
  }

  /**
   * Computes the 3D area of this triangle. The value computed is always
   * non-negative.
   * 
   * @return the 3D area of this triangle
   */
  public double area3D()
  {
    return area3D(this.p0, this.p1, this.p2);
  }

  /**
   * Computes the Z-value (elevation) of an XY point on a three-dimensional
   * plane defined by this triangle (whose vertices must have Z-values). This
   * triangle must not be degenerate (in other words, the triangle must enclose
   * a non-zero area), and must not be parallel to the Z-axis.
   * <p>
   * This method can be used to interpolate the Z-value of a point inside this
   * triangle (for example, of a TIN facet with elevations on the vertices).
   * 
   * @param p
   *          the point to compute the Z-value of
   * @return the computed Z-value (elevation) of the point
   */
  public double interpolateZ(Point3D p)
  {
    if (p == null)
      throw new IllegalArgumentException("Supplied point is null.");
    return interpolateZ(p, this.p0, this.p1, this.p2);
  }

}
