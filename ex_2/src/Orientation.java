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


import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateSequence;

/**
 * Functions to compute the orientation of basic geometric structures
 * including point triplets (triangles) and rings.
 * Orientation is a fundamental property of planar geometries 
 * (and more generally geometry on two-dimensional manifolds).
 * <p>
 * Orientation is notoriously subject to numerical precision errors
 * in the case of collinear or nearly collinear points.  
 * JTS uses extended-precision arithmetic to increase
 * the robustness of the computation.
 * 
 * @author Martin Davis
 *
 */
public class Orientation {
  /**
   * A value that indicates an orientation of clockwise, or a right turn.
   */
  public static final int CLOCKWISE = -1;
  /**
   * A value that indicates an orientation of clockwise, or a right turn.
   */
  public static final int RIGHT = CLOCKWISE;
  /**
   * A value that indicates an orientation of counterclockwise, or a left turn.
   */
  public static final int COUNTERCLOCKWISE = 1;
  /**
   * A value that indicates an orientation of counterclockwise, or a left turn.
   */
  public static final int LEFT = COUNTERCLOCKWISE;
  /**
   * A value that indicates an orientation of collinear, or no turn (straight).
   */
  public static final int COLLINEAR = 0;
  /**
   * A value that indicates an orientation of collinear, or no turn (straight).
   */
  public static final int STRAIGHT = COLLINEAR;

  /**
   * Returns the orientation index of the direction of the point <code>q</code> relative to
   * a directed infinite line specified by <code>p1-p2</code>.
   * The index indicates whether the point lies to the {@link #LEFT} or {@link #RIGHT}
   * of the line, or lies on it {@link #COLLINEAR}.
   * The index also indicates the orientation of the triangle formed by the three points
   * ( {@link #COUNTERCLOCKWISE}, {@link #CLOCKWISE}, or {@link #STRAIGHT} )
   * 
   * @param p1 the origin point of the line vector
   * @param p2 the final point of the line vector
   * @param q the point to compute the direction to
   * 
   * @return -1 ( {@link #CLOCKWISE} or {@link #RIGHT} ) if q is clockwise (right) from p1-p2;
   *         1 ( {@link #COUNTERCLOCKWISE} or {@link #LEFT} ) if q is counter-clockwise (left) from p1-p2;
   *         0 ( {@link #COLLINEAR} or {@link #STRAIGHT} ) if q is collinear with p1-p2
   */
  public static int index(Coordinate p1, Coordinate p2, Coordinate q)
  {
    /*
     * MD - 9 Aug 2010 It seems that the basic algorithm is slightly orientation
     * dependent, when computing the orientation of a point very close to a
     * line. This is possibly due to the arithmetic in the translation to the
     * origin.
     * 
     * For instance, the following situation produces identical results in spite
     * of the inverse orientation of the line segment:
     * 
     * Coordinate p0 = new Coordinate(219.3649559090992, 140.84159161824724);
     * Coordinate p1 = new Coordinate(168.9018919682399, -5.713787599646864);
     * 
     * Coordinate p = new Coordinate(186.80814046338352, 46.28973405831556); int
     * orient = orientationIndex(p0, p1, p); int orientInv =
     * orientationIndex(p1, p0, p);
     * 
     * A way to force consistent results is to normalize the orientation of the
     * vector using the following code. However, this may make the results of
     * orientationIndex inconsistent through the triangle of points, so it's not
     * clear this is an appropriate patch.
     * 
     */
    return CGAlgorithmsDD.orientationIndex(p1, p2, q);

    // testing only
    //return ShewchuksDeterminant.orientationIndex(p1, p2, q);
    // previous implementation - not quite fully robust
    //return RobustDeterminant.orientationIndex(p1, p2, q);
  }
}