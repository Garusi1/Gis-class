package game;

import java.util.ArrayList;
import java.util.Iterator;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import com.sun.xml.bind.marshaller.DumbEscapeHandler;

import Coords.MyCoords;
import Geom.Point3D;

public class packman {

	private Point3D packmanPoint;
	double speed;
	double Radius;
	private static int id=-1;
	double timing=0;
	int Stops;
	public Path path;


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
	

	public Point3D getLocationByTime(double time) {
		MyCoords mc = new MyCoords();
		if(time <= 0) {return path.getPathPoint(0);}
		if(time >= timing) {return path.getPathPoint(path.size());}
		
		Iterator<Point3D> iter = (Iterator<Point3D>) this.path.pathPoints ;
		while(iter.hasNext()) {
			if(iter.next().getTime()==time)  {return iter.next();}
			
			if(time>iter.next().getTime()){
			
			Point3D befor = iter.next();
			iter.next();
			Point3D after = iter.next();
			double difference = (time-befor.getTime())/(after.getTime()-befor.getTime());
			Point3D oldVec = 	mc.vector3D(befor, after);
			double newx = difference*oldVec.x();
			double newy = difference*oldVec.y();
			double newz = difference*oldVec.z();
			Point3D newVec = new Point3D(newx, newy, newz);
			
			Point3D result = mc.add(befor, newVec);
			
			return result;}
			
			iter.next();
		}

		return null;
	}

}
