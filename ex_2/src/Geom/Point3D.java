/*
 * 
 */
package Geom;


import java.awt.Point;
import java.io.Serializable;
// TODO: Auto-generated Javadoc

/**
 * The Class Point3D.
 */
public class Point3D implements Geom_element, Serializable 
{
	/**
	 * This class represents a 3D point in space.
	 */
	private static final long serialVersionUID = 1L;

	/** The z. */
	private double _x,_y,_z;

	private double time;

	/**
	 * Instantiates a new point 3 D.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	// full cons
	public Point3D(double x,double y,double z) 
	{
		_x=x;
		_y=y;
		_z=z;
	}

	/**
	 * Instantiates a new point 3 D.
	 *
	 * @param p the p
	 */
	//	copy cons
	public Point3D(Point3D p) 
	{
		_x=p.x();
		_y=p.y();
		_z=p.z();
	}

	/**
	 * Instantiates a new point 3 D.
	 *
	 * @param x the x
	 * @param y the y
	 */
	//	partial cons z=0
	public Point3D(double x,double y) 
	{this(x,y,0);}

	/**
	 * Sets the.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public void set (double x,double y, double z) {
		_x = x;
		_y = y;
		_z = z;

	}


	/**
	 * Instantiates a new point 3 D.
	 *
	 * @param s the s
	 */
	//	string cons
	public Point3D(String s) {
		String[] a = s.split(",");
		_x = Double.parseDouble(a[0]);
		_y = Double.parseDouble(a[1]);
		_z = Double.parseDouble(a[2]);
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(double x) {
		this._x=x;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(double y) {
		this._y=y;
	}

	/**
	 * Sets the z.
	 *
	 * @param z the new z
	 */
	public void setZ(double z) {
		this._z=z;
	}
	///////////////////////////////////////////////////////////////////////////
	////////////////////////////       methods        /////////////////////////
	///////////////////////////////////////////////////////////////////////////


	/**
	 * X.
	 *
	 * @return the double
	 */
	public double x() {return _x;}

	/**
	 * Y.
	 *
	 * @return the double
	 */
	public double y() {return _y;}

	public void setTime(double x) 
	{
		time = x;
	}
	public double getTime() 
	{
		return time; 
	}
	
	/**
	 * Z.
	 *
	 * @return the double
	 */
	public double z() {return _z;}

	/**
	 * Ix.
	 *
	 * @return the int
	 */
	// conversion to int
	public int ix() {return (int)_x;}

	/**
	 * Iy.
	 *
	 * @return the int
	 */
	public int iy() {return (int)_y;}

	/**
	 * Iz.
	 *
	 * @return the int
	 */
	public int iz() {return (int)_z;}

	/**
	 * Adds the.
	 *
	 * @param p the p
	 */
	//		add another point  values to the layer
	public void add(Point3D p) { add(p._x,p._y,p._z);}

	//	add points values by arguments

	/**
	 * Adds the.
	 *
	 * @param dx the dx
	 * @param dy the dy
	 * @param dz the dz
	 */
	public void add(double dx, double dy, double dz) {
		_x+=dx;_y+=dy;_z+=dz;
	}
	//	add points by x,y while z=0

	/**
	 * Adds the.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void add(double x, double y){this.add(x,y,0);}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	// toString
	public String toString() 
	{
		return ""+_x+","+_y+","+_z;
	}

	/* (non-Javadoc)
	 * @see Geom.Geom_element#distance2D(Geom.Point3D)
	 */
	public double distance2D(Point3D p2) { 
		return this.distance3D(p2.x(), p2.y(), this.z());
	}

	/* (non-Javadoc)
	 * @see Geom.Geom_element#distance3D(Geom.Point3D)
	 */
	public double distance3D(Point3D p2) {
		return this.distance3D(p2.x(), p2.y(), p2.z());}

	/**
	 * Distance 3 D.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @return the double
	 */
	public double distance3D(double x, double y , double z)
	{
		double dx = _x-x;
		double dy = _y-y;
		double dz = _z-z;
		double t = dx*dx+dy*dy+dz*dz;
		return Math.sqrt(t);
	}

	/**
	 * Equals.
	 *
	 * @param p2 the p 2
	 * @return true, if successful
	 */
	public boolean equals(Point3D p2)
	{
		return ( (_x==p2._x) && (_y==p2._y) && (_z==p2._z) );
	}

	/**
	 * Close 2 equals.
	 *
	 * @param p2 the p 2
	 * @param dist the dist
	 * @return true, if successful
	 */
	public boolean close2equals(Point3D p2, double dist)
	{
		return ( this.distance3D(p2)< dist );
	}

	/**
	 * Equals XY.
	 *
	 * @param p the p
	 * @return true, if successful
	 */
	public boolean equalsXY (Point3D p)
	{return p._x == _x && p._y == _y;}

	/**
	 * To file.
	 *
	 * @return the string
	 */
	public String toFile()  {return _x+","+_y+","+_z;}

	/**
	 * To file 1.
	 *
	 * @return the string
	 */
	public String toFile1()  {return "Point3D "+_x+" "+_y+" "+_z;}

	////////////////////////////////////////////////////////////////////////////////////////

	/** The Constant ERROR. */
	public final static int ONSEGMENT = 0,  LEFT = 1, RIGHT = 2, INFRONTOFA = 3, BEHINDB = 4, ERROR = 5;

	/** The Constant UP. */
	public final static int DOWN = 6, UP = 7;

	/**
	 *  return up if this point is above the SEGMENT (not the line).
	 *
	 * @param a the a
	 * @param b the b
	 * @return the int
	 */
	public int pointLineTest2(Point3D a, Point3D b) {
		int flag = this.pointLineTest(a,b);
		if(a._x < b._x ) {
			if(a._x<=_x && b._x>_x) {
				if (flag == LEFT) return DOWN;
				if (flag == RIGHT) return UP;
			}
		}
		else 
			if(a._x > b._x ) {
				if(b._x<=_x && a._x>_x) {
					if (flag == RIGHT) return DOWN;
					if (flag == LEFT) return UP;
				}
			}	
		return flag;
	}


	/**
	 *  pointLineTest <br>
	 * 	test the following location of a point regards a line segment - all in 2D projection.<br><br>
	 * 
	 * 	ONSEGMENT:  �����a----+----b������                              <br> <br>
	 * 
	 * 	           +       +        +                              <br>
	 * 	LEFT:	 �����a---------b������                              <br> <br>
	 * 
	 * 
	 * 	RIGHT:	 �����a---------b������                              <br>
	 *     		   +      +        +                              <br> <br>
	 * 
	 * 	INFRONTOFA:  ��+��+a---------b������                              <br>
	 *         BEHINDB:  �����a---------b����+�                              <br>
	 * 	ERROR: a==b || a==null || b == null;                               <br>
	 *
	 * @param a the a
	 * @param b the b
	 * @return the int
	 */

	public int pointLineTest(Point3D a, Point3D b) {

		if(a== null || b==null || a.equalsXY(b)) return ERROR;

		double dx = b._x-a._x;
		double dy = b._y-a._y;
		double res = dy*(_x-a._x)-dx*(_y-a._y);

		if (res < 0) return LEFT;
		if (res > 0) return RIGHT;

		if (dx > 0) {
			if (_x < a._x) return INFRONTOFA;
			if (b._x < _x) return BEHINDB;
			return ONSEGMENT;
		}
		if (dx < 0) {
			if (_x > a._x) return INFRONTOFA;
			if (b._x > _x) return BEHINDB;
			return ONSEGMENT;
		}
		if (dy > 0) {
			if (_y < a._y) return INFRONTOFA;
			if (b._y < _y) return BEHINDB;
			return ONSEGMENT;
		}
		if (dy < 0) {
			if (_y > a._y) return INFRONTOFA;
			if (b._y > _y) return BEHINDB;
			return ONSEGMENT;
		}
		return ERROR;
	}


	/**
	 * Rescale.
	 *
	 * @param center the center
	 * @param vec the vec
	 */
	////////////////////////////////////////////////////////////////
	public void rescale(Point3D center, Point3D vec) {
		if(center!=null && vec != null)
			rescale(center,vec.x(),vec.y(),vec.z());
	}

	/**
	 * Rescale.
	 *
	 * @param center the center
	 * @param size the size
	 */
	public void rescale(Point3D center, double size) {
		if(center!=null && size>0)
			rescale(center,size,size,size);
	}

	/**
	 * Rescale.
	 *
	 * @param center the center
	 * @param sizeX the size X
	 * @param sizeY the size Y
	 * @param sizeZ the size Z
	 */
	private void rescale(Point3D center, double sizeX,double sizeY, double sizeZ) {
		_x = center._x + ((_x - center._x) * sizeX);
		_y = center._y + ((_y - center._y) * sizeY);
		_z = center._z + ((_z - center._z) * sizeZ);
	} 

	// rotation by radius and angel from the center point

	/**
	 * Rotate 2 D.
	 *
	 * @param center the center
	 * @param angle the angle
	 */
	public void rotate2D(Point3D center, double angle) {
		// angle -1/2PI .. 1/2Pi regular degrees. 
		_x = _x - center.x();
		_y = _y - center.y();
		// after this math, the fuction below returns ths angel between the tow points in radians
		double a = Math.atan2(_y,_x);
		//	System.out.println("Angle: "+a);
		double radius = Math.sqrt((_x*_x) + (_y*_y));
		_x = (center.x() +  radius * Math.cos(a+angle)); // moves the point to the new location (radius in the angel from the center)
		_y = (center.y() +  radius * Math.sin(a+angle));
	}								

	/**
	 *  computes the angleXY between p1 and p2 in RADIANS: <br><br>
	 * 	up:(PI/2)  , down (-PI/2) , right(0),  left(+- PI).   [-PI, +PI]
	 *
	 * @param p the p
	 * @return the double
	 */
	public double angleXY(Point3D p) {
		if(p==null) throw new RuntimeException("** Error: Point3D angle got null **");
		return Math.atan2((p._y-_y), (p._x-_x));
	}

	/**
	 *  computes the angleXY between p1 and p2 in RADIANS: <br><br>
	 * 	up:(PI/2)  , down (1.5PI) , right(0),  left(PI).   [0,2PI].
	 *
	 * @param p the p
	 * @return the double
	 */
	public double angleXY_2PI(Point3D p) {
		if(p==null) throw new RuntimeException("** Error: Point3D angle got null **");
		double ans = Math.atan2((p._y-_y), (p._x-_x));
		if (ans<0) ans = 2*Math.PI+ans;
		return ans;
	}

	/**
	 *  computes the angleZ between p1 and p2 in RADIANS.
	 *
	 * @param p the p
	 * @return the double
	 */ 							
	public double angleZ(Point3D p) {
		if(p==null) throw new RuntimeException("** Error: Point3D angleZ got null **");
		return Math.atan2((p._z-_z), this.distance2D(p));
	}	
	/** return the (planer angle of the vector between this --> p, in DEGREES, in a
	 * compass order: north 0, east 90, south 180, west 270.
	 * @param p is the end point of the vector (z value is ignored). 
	 * @return angle in compass styye [0,360).
	 */
	public double north_angle(Point3D p) {
		double ans = 0;
		double a_rad = Math.atan2((p._y-_y), (p._x-_x));
		double a_deg = Math.toDegrees(a_rad);
		if(a_deg<=90) ans = 90-a_deg;
		else ans = 450-a_deg;
		return ans;
	}

	/**
	 *  return the vertical angles in DEGREES of the vector this-->p.
	 *
	 * @param p the p
	 * @return the double
	 */
	public double up_angle(Point3D p) {
		double ans = 0;
		ans = Math.atan2((p._z-_z), this.distance2D(p));
		return Math.toDegrees(ans);
	}

	/**
	 *  return the vertical angles in DEGREES of the vector this-->p, .
	 *
	 * @param p the p
	 * @param h the h
	 * @return the double
	 */
	public double up_angle(Point3D p, double h) {
		double ans = 0;
		ans = Math.atan2((p._z+h-_z), this.distance2D(p));
		return Math.toDegrees(ans);
	}

	/**
	 *  transform from radians to angles.
	 *
	 * @param a the a
	 * @return the double
	 */
	public static double r2d(double a) { return Math.toDegrees(a);}

	/**
	 *  transform from radians to angles.
	 *
	 * @param a the a
	 * @return the double
	 */
	public static double d2r(double a) { return Math.toRadians(a);}

	//	public Point3D gpsToMeter () {
	//		double m2g = 0.000008993;
	//
	//		double g2m = 1/0.000008993;
	//		double metX = _x*g2m;
	//		double metY= _y*g2m;
	//		double metZ = _z;
	//
	//		Point3D output = new Point3D(metX, metY, metZ);
	//
	//		return output;
	//	}
	//	
	//	public Point3D MerToGeo() { // https://www.colby.edu/chemistry/Colby%20Compass/AcqBathometricData.pdf
	// 		double	RadToDeg = 57.29577951322447;
	//		double DegToRad = 0.0174532925199;
	////		double b = 6356752.3142;
	//		double b = 6378100; // another radius of earth
	//		double	PI = 3.141592654;
	//		double q =Math.atan(_z/Math.sqrt((_x*_x+_y*_y)));
	//		double	HALF_PI = 1.570796327;
	//		double MerToGeoLong = _x * RadToDeg / b;
	//		double MerToGeoLat = RadToDeg * (2 * Math.atan(Math.exp(_y / b)) - HALF_PI);
	//		double nn =Math.atan(_z/Math.sqrt((_x*_x+_y*_y)));
	//		double z = b * Math.cos(q);
	//		
	//		Point3D output = new Point3D(MerToGeoLong,MerToGeoLat,z);	
	//		
	//		return output;}
	//	public Point3D gpsToMer() {
	// 		double DegToRad = 0.0174532925199;
	//		double b = 6378100; // another radius of earth
	////		double b = 6356752.3142; 
	//		final double R = 6371000;
	//		final double P = Math.PI/180;
	//		double lat0 = Math.cos(_y*P);
	// 		
	//		double PI = 3.141592654;
	//		double HALF_PI = 1.570796327;
	//		double GeoToMerX = _x * DegToRad * b;
	//		double	GeoToMerY = b * (Math.log((Math.tan((_y * DegToRad + HALF_PI) * 0.5))));
	//		double Gps_z =  Math.cos(_x);
	//		System.out.println(GeoToMerY);
	//		Point3D p = new Point3D(GeoToMerX, GeoToMerY,Gps_z);
	//		double rad_x = _x*P;
	//		double rad_y = _y*P;
	//				
	//		double x = Math.cos(rad_x)*lat0*R;
	//		double y = Math.sin(rad_y)*R;
	// 		Point3D p1 = new Point3D(x, y, _z);
	//		return p1;}

	/**
	 * Meter 2 gps.
	 *
	 * @return the point 3 D
	 */
	public Point3D meter2Gps () {

		double m2g = 0.000008993;

		double gpsY= _y*m2g;
		double gpsX = _x*m2g/ Math.cos(gpsY * (Math.PI / 180));
		double gpsZ = _z;

		Point3D output = new Point3D(gpsX, gpsY, gpsZ);

		return output;

	}

	/**
	 * Gps 2 meter.
	 *
	 * @return the point 3 D
	 */
	public Point3D Gps2Meter () {

		double m2g = 0.000008993;

		double metY= _y/m2g;
		double metX = (_x*Math.cos(_y * (Math.PI / 180))/m2g);
		double metZ = _z;

		Point3D output = new Point3D(metX, metY, metZ);

		return output;

	}

	/**
	 * Vector.
	 *
	 * @param p the p
	 * @return the point 3 D
	 */
	public Point3D vector (Point3D p) {

		double m2g = 0.000008993;

		double metx = +(p.x()-_x)*Math.cos(_y*Math.PI/180)/m2g;	
		double mety = +(p.y()-_y)/m2g;

		Point3D out = new Point3D(metx, mety,p.z()-_z);

		return out;
	}






	//	public double upangle1 (Point3D p) {
	//		double x = p.gpsToMeter()._x - this.gpsToMeter()._x;
	//		double y = p.gpsToMeter()._y - this.gpsToMeter()._y;
	//		double z = p.z()-_z;
	//		
	//		return ((z/mc.)*45);
	//
	//	}






}



////////////////////////////////////////////////////////////////////////////////

