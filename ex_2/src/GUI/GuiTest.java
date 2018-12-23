package GUI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;

// TODO: Auto-generated Javadoc
/**
 * The Class GuiTest.
 */
class GuiTest {

	/**
	 * GPS 2 pixel test.
	 */
	@Test
	void GPS2Pixel_Test() {
		map m = new map();
		Point3D leftUp=new Point3D(35.202316,32.105729);
		leftUp = m.GPS2Pixel(leftUp);
		Point3D rightAns=new Point3D(0,0);

		assertTrue(rightAns.equals(leftUp));;
	}
	
	/**
	 * GPS 2 pixel test 2.
	 */
	@Test
	void GPS2Pixel_Test2() {
		map m = new map();
		 Point3D rightDown=new Point3D(35.210720,32.102096);
		 rightDown = m.GPS2Pixel(rightDown);
		Point3D rightAns=new Point3D(1114.8926260415562,327.4627423203879);

		assertTrue(rightAns.equals(rightDown));;
	}
	
	/**
	 * Pixel 2 GP S test.
	 */
	@Test
	void Pixel2GPS_Test() {
		map m = new map();
		Point3D leftUp =new Point3D(0,0);
		leftUp = m.Pixel2GPS(leftUp.x(),leftUp.y());
		Point3D rightAns=new Point3D(35.202316,32.105729);

		assertTrue(rightAns.equals(leftUp));;
	}
	
	/**
	 * Pixel 2 GP S test 2.
	 */
	@Test
	void Pixel2GPS_Test2() {
		map m = new map();
		Point3D leftUp =new Point3D(20,20);
		leftUp = m.Pixel2GPS(leftUp.x(),leftUp.y());
		System.out.println(leftUp);
		Point3D rightAns=new Point3D(35.202466758912635,32.10595088783824);

		assertTrue(rightAns.equals(leftUp));;
	}
	
}
