import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Coords.MyCoords;
import Geom.Point3D;

class coordsTest {

	@Test
	void isValid_GPS_PointTest() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(390,5,6);
		boolean x=c.isValid_GPS_Point(p);
		assertTrue(x);
	}
	
	@Test
	void addTest() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(390,5,6);
		boolean x=c.isValid_GPS_Point(p);
		assertTrue(x);
	}
	@Test
	void distance3dTest() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(390,5,6);
		boolean x=c.isValid_GPS_Point(p);
		assertTrue(x);
	}
	@Test
	void vector3DTest() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(390,5,6);
		boolean x=c.isValid_GPS_Point(p);
		assertTrue(x);
	}
	@Test
	void azimuth_elevation_distTest() {
		MyCoords c=new MyCoords();
		Point3D p=new Point3D(390,5,6);
		boolean x=c.isValid_GPS_Point(p);
		assertTrue(x);
	}

}

}
