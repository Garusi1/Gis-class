package ex_3;

import Geom.Point3D;

public class packman {
	
	private Point3D packmanPoint;
	double speed;
	double Radius;
	private static int id=-1;
	
	public packman(Point3D p, String color) {
		packmanPoint = p;
		id++;
	}
	public packman(Point3D p) {
		packmanPoint = p;
		id++;
	}
	public packman(double x, double y) {
		packmanPoint = new Point3D(x,y);
		id++;
	}
	public Point3D getPoint() {
		return packmanPoint;
	}
	
	public void setPoint(Point3D p) {
		packmanPoint = p;
	}

	
}
