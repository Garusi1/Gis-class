package Coords;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import com.sun.xml.internal.ws.policy.PolicyIntersector;

import Geom.Point3D;

class coordsTest {

	@Test
	void isValid_GPS_PointTest() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(50,5);
		boolean x=c.isValid_GPS_Point(p);
		assertTrue(x);
	}
	@Test
	void isValid_GPS_PointTest2() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(200,5); // long>180 -->false
		boolean x=c.isValid_GPS_Point(p);
		assertFalse(x);
	}
	@Test
	/**
	 * from boaz example
	 */
	void addTest() {
		MyCoords c=new MyCoords();
		Point3D p = new Point3D(35.209039,32.103315 , 670);
		Point3D local_vector_in = new Point3D(-359.2492069, 337.6989921, -20);
		Point3D out = c.add(p,local_vector_in);

		Point3D rightAns= new Point3D(35.205225, 32.106352, 650); // 

		assertEquals(out.x(),rightAns.x(),0.001);;

	}
	@Test
	/**
	 * from boaz example
	 */
	void distance3dTest() {
		MyCoords c=new MyCoords();
		Point3D p = new Point3D(35.209039,32.103315 , 670);
		Point3D p1= new Point3D(35.205225, 32.106352, 650); // 

		double dis = c.distance3d(p, p1);
System.out.println(dis);
		double rightAns = 493.4578016; // the real distance between the two points

		assertEquals(dis,rightAns,0.1);
	}
	@Test
	void vector3DTest() {
		MyCoords c=new MyCoords();

		MyCoords mc = new MyCoords();

		Point3D p = new Point3D(35.209039,32.103315 , 670);
		Point3D p1 = new Point3D(35.205225, 32.106352, 650);
		Point3D rightAns = new Point3D(-359.2492069, 337.6989921, -20);

		Point3D ans = c.vector3D(p, p1);

		boolean flag = true;
		flag = ((rightAns.x()==ans.x())&&rightAns.y()==ans.y()&&rightAns.z()==ans.z());

		assertEquals(rightAns.x(),ans.x(),0.01);		
		assertEquals(rightAns.y(),ans.y(),0.01);	
		assertEquals(rightAns.z(),ans.z(),0.01);		


	}
	@Test
	void azimuth_elevation_distTest() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(34.8085 ,32.16275);
		Point3D p1= new Point3D(34.813006686487164,32.16656500793215, 6356752.314199897);

		double [] arr = c.azimuth_elevation_dist(p, p1);


	}

}


