package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class MyGisElement {

	
	private Point3D p;
	private String color,timing,data ;

	
	/** return a String representing this data */

	public MyGisElement( Point3D p1, String color1, String timing1, String data1) {
	p=p1;
	color = color1;
	timing = timing1;
	data = data1;	
	}
	public MyGisElement(Point3D p1) {
		p=p1;
		color = "null";
		timing = "null";
		data = "null";		
	}
	public MyGisElement() {
		p = null;
		color = "null";
		timing = "null";
		data = "null";
	}
	public void setPoint (Point3D p1) {
	p=p1;
	}
	public void setData (String color1,String timing1,String data1) {
		color = color1;
		timing = timing1;
		data = data1;
		}
	public void setMyGisElement (Point3D p1, String color1,String timing1,String data1) {
		p=p1;
		color = color1;
		timing = timing1;
		data = data1;
		}
	public MyGisElement getGeom() {
	return this;	
	}
	
	// set, delete
	public Meta_data getData() {
		return null;
	}
	
	
	public void translate(Point3D vec) {
		
}
}
