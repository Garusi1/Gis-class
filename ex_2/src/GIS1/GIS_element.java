/*
 * 
 */
package GIS1;

import Geom.Geom_element;
import Geom.Point3D;

// TODO: Auto-generated Javadoc
/**
 * This interface represents a GIS element with geometric representation and meta data such as:
 * Orientation, color, string, timing...
 * @author Boaz Ben-Moshe
 *
 */
public interface GIS_element {
	// constructors
	
	/**
	 * Gets the geom.
	 *
	 * @return the geom
	 */
	public Geom_element getGeom();
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	// set, delete
	public Meta_data getData();
	
	/**
	 * Translate.
	 *
	 * @param vec the vec
	 */
	public void translate(Point3D vec);
}
