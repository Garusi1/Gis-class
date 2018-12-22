package game;

import Coords.MyCoords;
import Geom.Point3D;
import game_Solution.Path;

public class packman {

	/**
	 * this class represents Pakcman, with basic functions
	 *  
	 *   
	 */

	private Point3D packmanPoint;  //saves the current packman location in GPS point
	double speed; // packman speed by meter to seconds
 	double Radius;// packman radius by meters
	private static int id=-1;
	double timing=0; // the time to finish his path
	int Stops;
	public Path path; // the packman path to the fruits, calculated by the algorithm


	/**
	 * constructors
	 * @param p
	 * @param color
	 */
	
	public packman(Point3D p, String color) {
		packmanPoint = p;
		id++;
		timing=0;
		path = new Path();
		path.add(packmanPoint);
		Stops = 0;
	}
	public packman() {
		packmanPoint = null;
		id++;
		timing=0;
		path = new Path();
		path.add(packmanPoint);
		Stops = 0;




	}
	public packman(Point3D p) {
		packmanPoint = p;
		id++;
		timing=0;
		path = new Path();
		path.add(packmanPoint);
		Stops = 0;




	}
	public packman(double x, double y, double z,double speed1,double radius1) {
		packmanPoint = new Point3D(x,y,z);
		Radius = radius1;
		speed= speed1;
		id++;
		timing=0;
		path = new Path();
		path.add(packmanPoint);
		Stops = 0;

		/**
		 * sets and get functions
		 */
		
	}
	public Point3D getPoint() {
		return packmanPoint;
	}

	public void setPoint(Point3D p) {
		packmanPoint = p;
	}
	public void addToPackTime(double time) {
		timing+=time;
	}

	public Path getPath() {
		return path;
	}
	
	public double getRadius() {
		return Radius;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public double getTiming() {
		return timing;
	}
	
	
	/**
	 * this functions receives time in seconds and return the packman location in the path at this time 
	 * @param time
	 * @return
	 */
	

	public Point3D getLocationByTime(double time) {
		MyCoords mc = new MyCoords();
		if(time <= 0) {return path.getPathPoint(0);} // before the running - at the start point
		if(time >= timing) {return path.getPathPoint(path.size()-1);}// after the running - at the end point
		
	
		for (int i = 0; i <path.pathPoints.size(); i++) { // find the tow points that the packman location by current time is between them
			if(path.pathPoints.get(i).getTime()==time) return path.pathPoints.get(i); // in case that the point is at the time of the fruit eating 
			if(time>path.pathPoints.get(i).getTime()){
				Point3D befor = path.pathPoints.get(i);
				Point3D after = path.pathPoints.get(i+1);
				double difference = (time-befor.getTime())/(after.getTime()-befor.getTime()); // saves the difference between the tow points
				Point3D oldVec = 	mc.vector3D(befor, after); // calculates the vector between the tow points 
				double newx = difference*oldVec.x();
				double newy = difference*oldVec.y();
				double newz = difference*oldVec.z();
				Point3D newVec = new Point3D(newx, newy, newz); // saves the new vector values
				
				Point3D result = mc.add(befor, newVec); // adds the vector to the right time to the "before" point
				
				return result;}
				
				
			}
			return null;
	}

}
