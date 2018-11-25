package GIS1;

import Geom.Geom_element;
import Geom.Point3D;

/**
 * This interface represents a GIS element with geometric representation and meta data such as:
 * Orientation, color, string, timing...
 * @author Boaz Ben-Moshe
 *
 */
public interface GIS_element {
	// constructors
	
	public Geom_element getGeom();
	
	// set, delete
	public Meta_data getData();
	
	public void translate(Point3D vec);
}
