package game;

import Geom.Point3D;

public class fruits {
	private Point3D fruitPoint;
	private int onOff; // 1 is on and 0 is off
	private static int generalId=0;
	private int id;
	
	public fruits(Point3D p) {
		fruitPoint= new Point3D(p);
		onOff = 1;
		id = generalId;
		generalId++;
	}
	public fruits() {
		onOff = 1;	
		id = generalId;
		generalId++;

	}
	public fruits(double x, double y, double z) {
		fruitPoint= new Point3D(x,y,z) ;
		onOff = 1;	
		id = generalId;
		generalId++;

	}
//	public String toString() {
//		
//		return ("x: "+fruitPoint.x() +" y: "+fruitPoint.y() +" generalId: "+id);
//	}
	
	public void setOff() {
		onOff = 0;	
	}
	public Point3D getPoint() {
		return fruitPoint;
	
	}
	public int getOnOff() {
		return onOff;
	}
	
	public String toString() {
		return (fruitPoint.toString()+id);
	}
	public fruits copy() {
		fruits f = new fruits();
		f.fruitPoint = fruitPoint;
		f.id = id;
		f.onOff = onOff;
		
		return f;
	}
	
	

}
