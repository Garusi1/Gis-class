package ex_3;

import Geom.Point3D;

public class fruits {
	private Point3D fruitPoint;
	private int onOff; // 1 is on and 0 is off
	
	public fruits(Point3D p) {
		fruitPoint= new Point3D(p);
		onOff = 1;		
	}
	public fruits(double x, double y) {
		fruitPoint= new Point3D(x,y)  ;
		onOff = 1;		

	}
	
	
	public void setOff() {
		onOff = 0;	
	}
	

}
