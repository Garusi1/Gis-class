package algorithms;

import com.sun.javafx.scene.paint.GradientUtils.Point;

import Coords.MyCoords;
import GIS1.GIS_element;
import GIS1.GIS_layer;
import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import Geom.Circle;
import Geom.rectangle;
import javafx.geometry.Point3D;

/**
 * @author mgaru
 * 
 * this class checks if point exist in other geum
 *
 */



public class inDis {
	/**
	 * @return true if the point is in the circle
	 *
	 */

	MyCoords mc = new MyCoords();
	public boolean inCircle(Circle c, Geom.Point3D p) {
		if (mc.distance3d(p,c.center())>c.radius()) {
			return false;
		}
		return true;
	}
	/**
	 * @return new layer with all the points which in the circle
	 *
	 */


	public MyGisLayer allInCircle(Circle c, GIS_layer l){
		MyGisLayer m = new MyGisLayer("inCircle");
		for (GIS_element gis_element : l) {
			MyGisElement my = (MyGisElement) l;
			if (inCircle(c, my.p)) {
				m.add(my);}
		}
		return m;
		
		/**
		 * @return true if the point is in the rectangle
		 *
		 */
	}
	public boolean inRectangle(rectangle r, Geom.Point3D p) {
		if(r.getcenter().Gps2Meter().x()+r.getx()/2>p.Gps2Meter().x()) {
			return false;
		}
		if(r.getcenter().Gps2Meter().x()-r.getx()/2<p.Gps2Meter().x()) {
			return false;
		}
		if(r.getcenter().Gps2Meter().y()-r.gety()/2>p.Gps2Meter().y()) {
			return false;
		}
		if(r.getcenter().Gps2Meter().y()+r.gety()/2<p.Gps2Meter().y()) {
			return false;
		}



		return true;
		/**
		 * @return a new layer with all the points that in the rectangle
		 *
		 */
	}
	public MyGisLayer allInRectangle(rectangle r, GIS_layer l){
		MyGisLayer m = new MyGisLayer("inRec");
		for (GIS_element gis_element : l) {
			MyGisElement my = (MyGisElement) l;
			if (inRectangle(r, my.p)) {
				m.add(my);}
		}
		return m;
	}
	

}




