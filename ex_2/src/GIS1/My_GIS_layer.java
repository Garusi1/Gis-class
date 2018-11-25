package GIS1;

import java.util.ArrayList;

import Geom.Geom_element;
import Geom.Point3D;

/**
 * This interface represents a GIS element with geometric representation and meta data such as:
 * Orientation, color, string, timing...
 * @author Boaz Ben-Moshe
 *
 */
public class My_GIS_layer {
	ArrayList<MyGisElement> gisLayer;
	Meta_data data;

	
	public My_GIS_layer(){
		gisLayer =new ArrayList<MyGisElement>();	

		
//	public Geom_element getGeom() {
//		return null;
//		
//	};
//	
	
	public Meta_data getData() {
		Meta_data data;
		
		
	};
	
//	public void translate(Point3D vec) {
//		
//	};
}

}
