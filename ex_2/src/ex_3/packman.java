package ex_3;

import Geom.Point3D;

public class packman {
	
	private Point3D packmanPoint;
	double speed;
	double Radius;
	private static int id=-1;
	double timing;

	
	public packman(Point3D p, String color) {
		packmanPoint = p;
		id++;
		timing=0;
	}
	public packman() {
		packmanPoint = null;
		id++;
		timing=0;

	}
	public packman(Point3D p) {
		packmanPoint = p;
		id++;
		timing=0;

	}
	public packman(double x, double y, double z,double speed1,double radius1) {
		packmanPoint = new Point3D(x,y,z);
		Radius = radius1;
		speed= speed1;
		id++;
		timing=0;

	}
	public Point3D getPoint() {
		return packmanPoint;
	}
	
	public void setPoint(Point3D p) {
		packmanPoint = p;
	}
	public void addSecond() {
		timing++;
	}
	

	
}
