/*
 * 
 */
package GIS1;

import Geom.Point3D;

// TODO: Auto-generated Javadoc
/**
 * The Interface Meta_data.
 */
public interface Meta_data {
	
	/**
	 *  returns the Universal Time Clock associated with this data;.
	 *
	 * @return the utc
	 */
	public long getUTC();
	
	/**
	 *  return a String representing this data.
	 *
	 * @return the string
	 */
	public String toString();
	
	/**
	 * Gets the orientation.
	 *
	 * @return the orientation: yaw, pitch and roll associated with this data;
	 */
	public Point3D get_Orientation();
}
