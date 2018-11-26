package GIS1;

import java.time.LocalDateTime;

import Geom.Geom_element;
import Geom.Point3D;

public class MyGisElement implements GIS_element {

	
	private Point3D p;
	private String color, data ;
	private long UTC;
	private LocalDateTime timing;
	
	
	/** return a String representing this data */

	public MyGisElement( Point3D p1, String color1, String timing1, String data1) {
	MetaData d = new MetaData();
	p=p1;
	color = color1;
	timing = d.correntTime(this);
	data = d.getUTCLocation(this);
	UTC = d.getUTC(this);
	
	}
	public MyGisElement(Point3D p1) {
		MetaData d = new MetaData();
		p=p1;
		color = "null";
		timing = d.correntTime(this);
		data = d.getUTCLocation(this);
		UTC = d.getUTC(this);
	}
	public MyGisElement() {
		MetaData d = new MetaData();
		p = null;
		color = "null";
		timing = d.correntTime(this);
		data = d.getUTCLocation(this);
		UTC = d.getUTC(this);
	}
	public void setPoint (Point3D p1) {
	p=p1;
	}
	public Point3D getPoint () {
		return p;
		
	}

	public void setData (String color1,String timing1) {
		color = color1;
		}
	public void setMyGisElement (Point3D p1, String color1) {
		p=p1;
		color = color1;
		}
	public void setpoint (Point3D p1) {
		p=p1;
		
		}
	public Geom_element getGeom() {
	return (Geom_element) this;	
	}
	
	public Meta_data getData() {
		MetaData d = new MetaData();
		d.utc = d.getUTC(this);
		d.utcName = d.getUTCLocation(this);
		d.ldt = d.correntTime(this);
		return d;
	}
	
	
	
	public void translate(Point3D vec) {
		
}
	public String toString() {
		String s = p.toString()+", "+color+", "+timing.toString() +", "+data+", "+UTC;
		
		return s;
		}
	
	
}
