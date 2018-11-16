package Coords;

import Geom.Point3D;
import java.util.Hashtable;
import java.util.Map;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.scene.paint.GradientUtils.Point;

public class coords_convertor {/**

		/** computes a new point which is the gps point transformed by a 3D vector (in meters)*/
	public static Point3D add(Point3D gps, Point3D local_vector_in_meter) {

		Point3D utmGps = Geo2UTM(gps);
		System.out.println(utmGps.toString());
		utmGps.add(local_vector_in_meter);
		System.out.println(utmGps.toString());
		Point3D outputGps = UTM2Geo(utmGps);
		System.out.println(outputGps.toString());

		return outputGps;

	}
	// return a new point with coords by the geographic method (latitute, longitute) of the point
	public static Point3D UTM2Geo(Point3D utm) {
		String s = ("36"+" "+"north" +" "+utm.x() +" "+utm.y() );
		System.out.println(s);
		UTM2Geo geo = new UTM2Geo(s);

		Point3D geoPoint = new Point3D(geo.longitude, geo.latitude, utm.z());

		return geoPoint;

	}
	// return a new point with coords by UTM METHOD 
	public static Point3D Geo2UTM(Point3D geo) {
		Geo2UTM utm = new Geo2UTM (geo.x(), geo.y());

		Point3D utmPoint = new Point3D(utm.Easting, utm.Northing, geo.z());

		return utmPoint;

	}


	//	public double distance3d(Point3D gps0, Point3D gps1) {


	public double distance3d(Point3D gps0, Point3D gps1) {
		Point3D p0 = Geo2UTM(gps0);
		Point3D p1 = Geo2UTM(gps1);

		return p0.distance3D(p1);


	}
	/** computes the 3D vector (in meters) between two gps like points */


	/** computes the 3D vector (in meters) between two gps like points */
	public Point3D vector3D(Point3D gps0, Point3D gps1) {

		Point3D vector = new Point3D(gps1.x()-gps0.x(), gps1.y()-gps0.y(), gps1.z()-gps0.z());

		return vector;
	}
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance*/
	public  double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {

		double [] ans = {0,0,0};

		ans[0] = gps0.north_angle(gps1);
		ans[1] = gps0.up_angle(gps1); 
		//				(gps1.z()-gps0.z())/(Math.sqrt((Math.pow((gps1.x()-gps0.x()), 2)
		//				+(Math.pow((gps1.y()-gps0.y()), 2)))));

		ans[2] = Math.abs(distance3d(gps1, gps0));


		return ans;

	}
	//	public static void main(String[] args) {
	//		Point3D p = new Point3D(0,0,20);
	//		Point3D p1 = new Point3D(2, 2, 10);
	//
	//		double [] c = azimuth_elevation_dist(p, p1);
	//		for (int i = 0; i < c.length; i++) {
	//			System.out.println(c[i]);
	//		}





	//		/**
	//		 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	//		 * @param p
	//		 * @return
	//		 */
	public boolean isValid_GPS_Point(Point3D p) {
		return( ((Math.abs(p.x())<180)&&(Math.abs(p.y()))<90));
	}
}



