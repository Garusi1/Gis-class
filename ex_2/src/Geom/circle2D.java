package Geom;

import Coords.MyCoords;

public class circle2D {
	
	private double R; // 
	private Point3D center; ; // 
	
	public circle2D(double r, Point3D p) {
		center = p;
		R = r;
	}
	public boolean isInside(Point3D p) {
		MyCoords mc = new MyCoords();
		if (this.center.distance2D(p)>this.R)
			return false;
		
		return true;
		
	}


}
