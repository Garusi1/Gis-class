package Coords;
import Coords.MyCoords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

import com.sun.javafx.geom.AreaOp.AddOp;

import Coords.MyCoords;
import Geom.Point3D;

public class main {

	public static void main(String[] args) {

		
		MyCoords mc = new MyCoords();
		Point3D p = new Point3D(32.222,33.333);
		Point3D p1 = new Point3D(32.223,33.334);

		System.out.println(mc.distance3d(p, p1));
				
		
	}

}
