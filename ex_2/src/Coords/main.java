package Coords;
import Coords.MyCoords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import com.sun.javafx.geom.AreaOp.AddOp;
import com.sun.javafx.geom.PickRay;

import Coords.MyCoords;
import Geom.Point3D;
import Geom.Triangle;

public class main {

	public static void main(String[] args) {

		MyCoords mc = new MyCoords();
		
		Point3D p = new Point3D(35.209039,32.103315 , 670);
		
		Point3D p1 = new Point3D(35.205225, 32.106352, 650);
		
		
		Point3D local_vector_in = new Point3D(-359.2492069, 337.6989921, -20);
		
		System.out.println(mc.add(p, local_vector_in).toString());
		
		double a[]= mc.azimuth_elevation_dist(p, p1);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
//				
		
	}

}
