package Coords;


import Geom.Point3D;
import java.util.Hashtable;
import java.util.Map;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.scene.paint.GradientUtils.Point;

public class MyCoords implements coords_converter {

	/**

		/** computes a new point which is the gps point transformed by a 3D vector (in meters)*/



	public  Point3D add(Point3D gps, Point3D local_vector_in_meter) { //https://stackoverflow.com/questions/7477003/calculating-new-longitude-latitude-from-old-n-meters
		MyCoords mc = new MyCoords();

		Point3D out = new Point3D (gps.Gps2Meter());
		out.add(local_vector_in_meter);
		out = out.meter2Gps();
		//double earth = 6378.137;  //radius of the earth in kilometer
		//		double earth = 6371;
		//		double	pi = Math.PI;
		//		double m = (1 / ((2 * pi / 360) * earth)) / 1000;  //1 meter in degree
		//
		//		double new_latitude = gps.y() + (local_vector_in_meter.y() * m);
		//		double  new_longitude = gps.x() + (local_vector_in_meter.x() * m) / Math.cos(gps.y() * (pi / 180));


		//		Point3D outputGps = new Point3D(new_longitude, new_latitude, gps.z()+local_vector_in_meter.z());

		return out;

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
		ans[0] = gps0.north_angle(gps1);
		ans[1] = gps0.up_angle(gps1); 
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



}

