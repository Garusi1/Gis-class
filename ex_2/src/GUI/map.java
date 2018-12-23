package GUI;

import Geom.Point3D;

// TODO: Auto-generated Javadoc
/**
 * 	
 * This class is about converting GPS points to image pixels and from image pixels to GPS points 
 * 
 * The distance calculation is done by MyCoords class, using map convert functions .
 *
 * @author Naor and Michael
 */

public class map {
	
	
	/** The x length. */
	final double x_length=1114.8926260415562;
	
	/** The y length. */
	final double y_length=327.4627423203879;
	
	/** The Width. */
	int Width=1433;
	
	/** The Heigth. */
	int Heigth=642;
	
	/** The left up. */
	final Point3D leftUp=new Point3D(35.202469,32.105770);
	
	/** The right down. */
	final Point3D rightDown=new Point3D(35.211588,32.101899);

	
//	public  Point3D Pixel2GPS(double Dx , double Dy) {
//
//
//		double lon_x = Dx / x_length+leftUp.y();
//		double lat_y = Dy / y_length+leftUp.x(); // or RightdDown.x()
//
//		Point3D ans_in_Gps = new Point3D(lat_y,lon_x);
//
//		return ans_in_Gps;
/**
 * Pixel 2 GPS.
 *
 * @param Dx the dx
 * @param Dy the dy
 * @return the point 3 D
 */
//	}
	public  Point3D Pixel2GPS(double Dx , double Dy) {


//		double lon_x = ((Dx*( rightDown.x()-leftUp.x()))/x_length)+leftUp.x();
//		double lat_y = ((Dy*( leftUp.y()-rightDown.y()))/y_length)+leftUp.y(); // or RightdDown.x()

		double yachasx = ((Dx))/1433;
		
		double lon_x = leftUp.x() + yachasx* (rightDown.x()-leftUp.x());

		double yachasy = (642-Dy)/642;

		
		double lat_y = rightDown.y()+ yachasy*(leftUp.y()-rightDown.y());

		Point3D ans_in_Gps = new Point3D(lon_x, lat_y);

		return ans_in_Gps;
	}
	
	/**
	 * GPS 2 pixel.
	 *
	 * @param p the p
	 * @return the point 3 D
	 */
	public  Point3D GPS2Pixel(Point3D p) {
		//		
		double Dx =((p.x()-leftUp.x())/(rightDown.x()-leftUp.x()))*Width;

		double Dy = (Math.abs((p.y()-leftUp.y()))/(leftUp.y()-rightDown.y()))*Heigth;

		return new Point3D(Dx,Dy);
	}
	
	
	

}
