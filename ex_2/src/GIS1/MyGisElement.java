package GIS1;

import java.time.LocalDateTime;

import com.sun.swing.internal.plaf.metal.resources.metal;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;
/**
 * This class represents a GIS element with geometric representation and meta data such as:
 * Orientation, color, string, timing...
 * @author Boaz Ben-Moshe
 *
*/

public class MyGisElement implements GIS_element {
/** 
 * The object variables 
 * p- point3d with gps/geo/lat-long style coords
 * color
 * data - location of this point (for example :Israel/jerusalem)
 * UTC - the utc time-zone of this point
 * timing- the date and time of the element creation
 * d- metaData object
 * description
 */
	
	private Point3D p; 
	private String color, data, description ;
	private long UTC;
	private LocalDateTime timing;
	private MetaData d;

	
	
	
	/**constructors */

	public MyGisElement( Point3D p1, String color1, String description1) {
	d = new MetaData();
	p=p1;
	color = color1;
	description = description1;
	timing = d.correntTime(this);
	data = d.getUTCLocation(this);
	UTC = d.getUTC(this);
	
	}
	public MyGisElement(Point3D p1) {
	d = new MetaData();
		p=p1;
		color = "null";
		timing = d.correntTime(this);
		data = d.getUTCLocation(this);
		UTC = d.getUTC(this);
	}
	public MyGisElement() {
	d = new MetaData();
		p = null;
		color = "null";
		timing = d.correntTime(this);
		data = d.getUTCLocation(this);
		UTC = d.getUTC(this);
	}
	
	/**general functions
	 * 
	 * sets and gets
	 * @param p1
	 */
	public void setPoint (Point3D p1) {
	p=p1;
	}
	public Point3D getPoint () {
		return p;
		
	}
	public String getdata () {
		return data;
		
	}public String getcolor () {
		return color;
		
	}public long getUTC () {
		return UTC;
		
	}
	public String getTime () {
		return timing.toString();
		
	}
	public String getPoint2dToString () {
		String s ="";
		s+=this.p.x();
		s+=",";
		s+=this.p.y();

		return s;
		
	}

	public void setData (String color1,String description1) {
		color = color1;
		description = description1;
		}
	public void setMyGisElement (Point3D p1, String color1, String description1) {
		p=p1;
		color = color1;
		description = description1;

		}
	public void setpoint (Point3D p1) {
		p=p1;
		
		}
	
	/** updating the creating time of the object to NOW
	 * 
	 */
	public void updateTimeToNow () {
		d = new MetaData();
		timing = d.correntTime(this) ;
	}
	
	
	public Geom_element getGeom() {
	return (Geom_element) this;	
	}
	/**@return the meta Data object 
	 * 
	 */
	public Meta_data getData() {
		
		return d;
	}
	
	/**adds the vector values to the point, using add function from mycoords
	 * 
	 */
	
	public void translate(Point3D vec) {
		MyCoords mc = new MyCoords();
		p= mc.add(p, vec);
		
}
	/**
	 * toString function
	 */
	public String toString() {
		String s = p.toString()+", "+color+", "+timing.toString() +", "+data+", "+UTC+", "+description;
		
		return s;
		}
	public boolean IsEquals (MyGisElement e) {
		return p.equals(e.p);
	}

	
	
}
