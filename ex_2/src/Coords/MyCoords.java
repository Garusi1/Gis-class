package Coords;



import Geom.Point3D;
import java.util.Hashtable;
import java.util.Map;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.scene.paint.GradientUtils.Point;

public class MyCoords implements coords_converter {

	/**
	 * 
	 * for gps points we used the usual Point3D while: long = x , lat = y , alt = z
	 */

	/** computes a new point which is the gps point transformed by a 3D vector (in meters)*/

	public  Point3D add(Point3D gps, Point3D local_vector_in_meter) { //https://stackoverflow.com/questions/7477003/calculating-new-longitude-latitude-from-old-n-meters
		MyCoords mc = new MyCoords();
		//
		//		Point3D out = new Point3D (gps.Gps2Meter());
		//		out.add(local_vector_in_meter);
		//		out = out.meter2Gps();
		double earth = 6378.137;  //radius of the earth in kilometer
		//				double earth = 6371;
		double	pi = Math.PI;
		double m = (1 / ((2 * pi / 360) * earth)) / 1000;  //1 meter in degree

		double new_latitude = gps.y() + (local_vector_in_meter.y() * m);
		double  new_longitude = gps.x() + (local_vector_in_meter.x() * m) / Math.cos(gps.y() * (pi / 180));


		Point3D outputGps = new Point3D(new_longitude, new_latitude, gps.z()+local_vector_in_meter.z());

		return outputGps;

	}


	/** converts the gps points to meters and computes the distance between them like points */

	public double distance3d(Point3D gps0, Point3D gps1) { 
		MyCoords mc = new MyCoords();

		Point3D v = gps0.vector(gps1);

		double dis = Math.sqrt(v.x()*v.x()+v.y()*v.y()+v.z()*v.z());

		return dis;


	}
	/** computes the 3D vector (in meters) between two gps like points */
	public Point3D vector3D(Point3D gps0, Point3D gps1) {

		MyCoords mc = new MyCoords();

		Point3D vector = gps0.vector(gps1);

		return vector;
	}
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance*/
	public  double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {

		MyCoords mc = new MyCoords();

		double [] ans = {0,0,0};
		ans[0] = mc.azimuth(gps0, gps1);
		ans[1] = mc.elevation(gps0,gps1); 
		ans[2] =(mc.distance3d(gps0, gps1));
		return ans;

	}
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p
	 * @return
	 */
	public boolean isValid_GPS_Point(Point3D p) {
		MyCoords mc = new MyCoords();

		return(((Math.abs(p.x())<180)&&(Math.abs(p.y()))<90) &&((p.z()<450000 && p.z()>-450)));
	}
	/**
	 * 
	 * @param gps0
	 * @param gps1
	 * @return azimuth
	 */

	public  double azimuth (Point3D gps0, Point3D gps1) { //https://stackoverflow.com/questions/9457988/bearing-from-one-coordinate-to-another
		double srcLat = Math.toRadians(gps0.y());
		double dstLat = Math.toRadians(gps1.y());
		double dLng = Math.toRadians(gps1.x() - gps0.x());

		return Math.toDegrees(Math.atan2(Math.sin(dLng) * Math.cos(dstLat),
				Math.cos(srcLat) * Math.sin(dstLat) - 
				Math.sin(srcLat) * Math.cos(dstLat) * Math.cos(dLng)));
	}
	/**
	 * 
	 * @param gps0
	 * @param gps1
	 * @return elevation between the points
	 * if the points is above / under each other return -1
	 * if the points are in the height return 0
	 */

	public  double elevation (Point3D gps0, Point3D gps1) {
		Point3D p1 = gps0.Gps2Meter();
		Point3D p2 = gps1.Gps2Meter();

		double dis = Math.sqrt((Math.pow((p2.x()-p1.x()),2)+Math.pow((p2.y()-p1.y()),2)));
		double dz = p2.z() - p1.z();
		if(dis == 0) if(dz>0) return 90; else return -90;
		if(dz == 0)  return 0;

		return Math.atan(dz/dis)*180/Math.PI;
	}







}



//	
//	public Point3D gps2meter(Point3D p) {
//		MyCoords mc = new MyCoords();
//
//		//double earth = 6378.137;  //radius of the earth in kilometer
//		double earth = 6371;
//		double	pi = Math.PI;
//		double m = (1 / ((2 * pi / 360) * earth)) / 1000;  //1 meter in degree
//
//		double new_latitude = (p.y() /m);
//		double  new_longitude = +p.x() * Math.cos(p.y()*pi/180)/m;
//		
//
//		double m2g = 0.000008993;
//
////		double metx = +(p.x())*Math.cos(_y*Math.PI/180)/m2g;	
//
//
//		Point3D outputGps = new Point3D(new_longitude, new_latitude, p.z());
//
//				return outputGps;
//}


