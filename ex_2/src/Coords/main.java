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
		Triangle m = new Triangle();
		m.set(3, 3, 3);
		m.p0
		MyCoords mc = new MyCoords();
		Point3D p = new Point3D(35.209039,32.103315 , 670);
		
		Point3D p1 = new Point3D(35.205225, 32.106352, 650);
		
		Point3D local_vector_in_meter = new Point3D(-359, 337, -20);
		
		System.out.println(p.toString());
		p=mc.add(p, local_vector_in_meter);
		System.out.println(p.toString());
		
//		System.out.println("lll" +p.upangle1(p1));
		
//		System.out.println("1: "+p.toString());
// 
//		p = p.gpsToMeterf();
//		 System.out.println("2 : "+p.toString());
//		p=p.meterToGpsf();
//		System.out.println("3: " +p.toString());
//		
//		
//		Point3D local_vector_in_meter  =new Point3D(0,50,0);
//		p = mc.add(p, local_vector_in_meter);
//		System.out.println("4: " +p.toString());
//
//		System.out.println(Math.PI);
		
				
		
	}

}
