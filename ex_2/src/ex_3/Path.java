package ex_3;

import java.util.ArrayList;

import GIS1.GIS_element;
import GIS1.MetaData;
import GIS1.MyGisElement;
import Geom.Point3D;

public class Path {

	private ArrayList<Point3D> pathPoints;
	private String timing;
	
	/** The data. */
	private MetaData data;
	
	/** The description. */
	private String description;

		public Path(Point3D p) {
		pathPoints = new ArrayList<Point3D>() ;
		pathPoints.add(p);
		data = new MetaData();
	}
		public Path() {
			pathPoints = new ArrayList<Point3D>() ;
			data = new MetaData();
		}
		
	
		public Path(ArrayList<Point3D> pathPoints1) {
		pathPoints = new ArrayList<Point3D>() ;
		pathPoints = pathPoints1 ;
		data = new MetaData();
	}
		public void add(Point3D p) {
			pathPoints.add(p);
		}

		
}
