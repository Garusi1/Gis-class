package game_Solution;

import java.util.ArrayList;

import GIS1.GIS_element;
import GIS1.MetaData;
import GIS1.MyGisElement;
import Geom.Point3D;
/**
 * This class represent object type of path.
 * this class contains list of points, timing metadata and description.
 * 
 * @author naor eliav and michael garusi
 *
 */
public class Path {
	

	public ArrayList<Point3D> pathPoints;
	public double timing =0;
	
	private MetaData data;
	
	
	private String description;
	/**
	 * constructor that get point
	 * @param p-point3d p
	 */

		public Path(Point3D p) {
		pathPoints = new ArrayList<Point3D>() ;
		pathPoints.add(p);
		data = new MetaData();
	}
		/**
		 * default constructor.
		 */
		public Path() {
			pathPoints = new ArrayList<Point3D>() ;
			data = new MetaData();
		}
		
	/**
	 * This constructor gets arraylist of point
	 * @param pathPoints1
	 */
		public Path(ArrayList<Point3D> pathPoints1) {
		pathPoints = new ArrayList<Point3D>() ;
		pathPoints = pathPoints1 ;
		data = new MetaData();
	}
		/**
		 * This function get point and add it to the list of point
		 * @param p-point3d
		 */
		public void add(Point3D p) {
			pathPoints.add(p);
		}
		/**
		 * This function add 1 to the timing
		 */
		public void plusSecond() {
		timing ++;
		}
		/**
		 * This function get timing and add it to the timing
		 * @param time
		 */
		public void addToTiming(double time) {
			timing+=time;
		}
		/**
		 * This function prints the path
		 * @return string
		 */
		public String toString() {
			String s = "";
			for (Point3D point3d : pathPoints) {
				s+=point3d.toString()+"\n";
			}
			return(s);
		}
		/**
		 * This function return the size of the aarylist
		 * @return
		 */
		public int size() {
			return(pathPoints.size());
		}
		/**
		 * This function prints the path
		 * @param p-path p
		 * @return string
		 */
		public String getPathCoords(Path p) {
			 String s = "";
			 for (Point3D point3d : pathPoints) {
				 s+= point3d.toString()+"-";			
			} 
			 return s;
			 
			
		}
		/**
		 * This function get number i and return the point at i index
		 * @param i
		 * @return point3d
		 */
		public Point3D getPoint(int i ) {
			return pathPoints.get(i);
		}
		/**
		 * This function get number i and return the point at i index
		 * @param i
		 * @return point3d
		 */
		public Point3D getPathPoint(int i) {
			return pathPoints.get(i);
		}
		
		

		
}