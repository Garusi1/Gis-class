/*
 * 
 */
package GIS1;

import java.time.LocalDateTime;

import com.sun.swing.internal.plaf.metal.resources.metal;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;
// TODO: Auto-generated Javadoc
/**
 * This class represents a GIS element with geometric representation and meta data such as:
 * Orientation, color, string, timing...
 * 
 * THIS class works with gps coords:
 * x - long
 * y - lat
 * z - alt
 * @author Naor and michael
 *
*/

public class MyGisElement implements GIS_element {

/**   The object variables  p- point3d with gps/geo/lat-long style coords color data - location of this point (for example :Israel/jerusalem) UTC - the utc time-zone of this point timing- the date and time of the element creation d- metaData object description. */
	
	public Point3D p; 
	
	/** The timing. */
	private String color, data, description,timing ;
	
	/** The utc. */
	private long UTC;
	
	/** The d. */
	private MetaData d;

	/**
	 * This constructor gets point, color, data ,description and timing.
	 *
	 * @param p1 the p 1
	 * @param color1 the color 1
	 * @param data1 the data 1
	 * @param description1 the description 1
	 * @param timing1 the timing 1
	 */
	public MyGisElement( Point3D p1, String color1,String data1, String description1,String timing1) {
		d = new MetaData();
		p=p1;
		color = color1;
		description = description1;
		timing = timing1;
		data = data1;
	}
	
/**
 * constructor that gets point,color,data,description,timin and utc.
 *
 * @param p1 the p 1
 * @param color1 the color 1
 * @param data1 the data 1
 * @param description1 the description 1
 * @param timing1 the timing 1
 * @param utc1 the utc 1
 */
	public MyGisElement( Point3D p1, String color1,String data1, String description1,String timing1, long utc1) {
		p=p1;
		color = color1;
		description = description1;
		timing = timing1;
		data = data1;
		UTC = utc1;
	}
	
	/**
	 * contructor that get point,color and description.
	 *
	 * @param p1 the p 1
	 * @param color1 the color 1
	 * @param description1 the description 1
	 */

	public MyGisElement( Point3D p1, String color1, String description1) {
	d = new MetaData();
	p=p1;
	color = color1;
	description = description1;
	timing = d.correntTime(this);
	data = d.getUTCLocation(this);
	UTC = d.getUTC(this);
	
	}
	
	 /**
 	 * contructor that get point.
 	 *
 	 * @param p1 the p 1
 	 */
	public MyGisElement(Point3D p1) {
	d = new MetaData();
		p=p1;
		color = "null";
		timing = d.correntTime(this);
		data = d.getUTCLocation(this);
		UTC = d.getUTC(this);
	}
	
	/**
	 * default constructor.
	 */
	public MyGisElement() {
	d = new MetaData();
		p = null;
		color = "null";
		timing = d.correntTime(this);
		data = d.getUTCLocation(this);
		UTC = d.getUTC(this);
	}
	
	/**
	 * fuction that get point an set it .
	 *
	 * @param p1 the new point
	 */
	public void setPoint (Point3D p1) {
	p=p1;
	}
	
	/**
	 * fuction that return point.
	 *
	 * @return the point
	 */
	public Point3D getPoint () {
		return p;
		
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getdata () {
		return data;
		
	}/**
 * Gets the color.
 *
 * @return the color
 */
public String getcolor () {
		return color;
		
	}/**
 * Gets the utc.
 *
 * @return the utc
 */
public long getUTC () {
		return UTC;
		
	}
	
	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public String getTime () {
		return timing.toString();
		
	}
	
	/**
	 * toString function.
	 *
	 * @return string
	 */
	public String getPoint2dToString () {
		String s ="";
		s+=this.p.x();
		s+=",";
		s+=this.p.y();

		return s;
		
	}

/**
 * this function get data and set it.
 *
 * @param color1 the color 1
 * @param description1 the description 1
 */
	public void setData (String color1,String description1) {
		color = color1;
		description = description1;
		}
	
	/**
	 * fuction that get point color and description and set it.
	 *
	 * @param p1 the p 1
	 * @param color1 the color 1
	 * @param description1 the description 1
	 */
	public void setMyGisElement (Point3D p1, String color1, String description1) {
		p=p1;
		color = color1;
		description = description1;

		}
	
	/**
	 * Sets the point.
	 *
	 * @param p1 the new point
	 */
	public void setpoint (Point3D p1) {
		p=p1;
		
		}
	
	/**
	 *  This function update the creating time of the object to NOW.
	 */
	public void updateTimeToNow () {
		d = new MetaData();
		timing = d.correntTime(this) ;
	}
	
	/**
	 * this function return geom element.
	 *
	 * @return the geom
	 */
	public Geom_element getGeom() {
	return (Geom_element) this;	
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the meta Data object
	 */
	public Meta_data getData() {
		
		return d;
	}
	
	/**
	 * This function adds the vector values to the point, using add function from mycoords.
	 *
	 * @param vec the vec
	 */
	
	public void translate(Point3D vec) {
		MyCoords mc = new MyCoords();
		p= mc.add(p, vec);
		
}
	
	/**
	 * toString function.
	 *
	 * @return the string
	 */
	public String toString() {
		String s = p.toString()+", "+color+", "+timing +", "+data+", "+UTC+", "+description;
		
		return s;
		}
	
	/**
	 * This function checks if twoe giselements are equals.
	 *
	 * @param e the e
	 * @return true if equal.
	 * else false.
	 */
	public boolean IsEquals (MyGisElement e) {
		if(e.color.equals(this.color)&&e.p.equals(this.p)&&e.data.equals(this.data)&&e.description.equals(this.description)) {
			return true;
		}
		return false;
	}
	
	/**
	 * This function return description.
	 *
	 * @return description.
	 */
	public String getDes() {
		return description;
	}

	
	
}