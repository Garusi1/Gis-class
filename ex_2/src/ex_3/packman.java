package ex_3;

import Geom.Point3D;

public class packman {
	
	private Point3D packmanPoint;
	private String _color;
	
	public packman(Point3D p, String color) {
		packmanPoint = p;
		_color = color;	
	}
	public packman(Point3D p) {
		packmanPoint = p;
		_color = "";
	}
	public Point3D getPoint() {
		return packmanPoint;
	}
	public String getColor() {
		return _color;
	}
	public void setPoint(Point3D p) {
		packmanPoint = p;
	}
	public void setColor(String color) {
		_color = color;
	}
	
}
