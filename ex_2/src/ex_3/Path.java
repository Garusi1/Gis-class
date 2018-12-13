package ex_3;

import java.util.ArrayList;

import GIS1.GIS_element;
import GIS1.MetaData;
import GIS1.MyGisElement;
import Geom.Point3D;

public class Path {

	private ArrayList<Point3D> pathPoints;
	private double timing =0;
	
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
		public void plusSecond() {
		timing ++;
		}
		public void addToTiming(double time) {
			timing+=time;
		}
		public String toString() {
			String s = "";
			for (Point3D point3d : pathPoints) {
				s+=point3d.toString()+"\n";
			}
			return(s);
		}
		public int size() {
			return(pathPoints.size());
		}
		
		public String getPathCoords(Path p) {
			 String s = "";
			 for (Point3D point3d : pathPoints) {
				 s+= point3d.toString()+"-";			
			} 
			 return s;
			 
			
		}

		
}
