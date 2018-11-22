package Coords;
import Coords.MyCoords;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sun.javafx.geom.AreaOp.AddOp;

import Coords.MyCoords;
import Geom.Point3D;

public class main {

	public static void main(String[] args) {
//	Point3D gps = new Point3D(32.33333,32.22222);
//	
//	
//	MyCoords c=new MyCoords();
//	Point3D p=new Point3D(34.814167, 32.171111 );
//	Point3D v=new Point3D(500,0,0);
//	
//
//	Point3D out = c.add(p, v);
//	
//	System.out.println("the ans " +out.toString() +" the right ans 34.819444");
	
//	the right answer as shown in google earth (with those parameters)
	
//	Point3D rightAns= new Point3D(34.813006686487164,32.16656500793215, 6356752.314199897);

//	MyCoords c=new MyCoords();
//	Point3D p=new Point3D(34.8085 ,32.16275 );
//	Point3D v=new Point3D(500, 500);
//	
//	Point3D out = c.add(p, v);
//	System.out.println(out.toString());
//	
	
//	MyCoords c=new MyCoords();
//	Point3D p=new Point3D(34.814167, 32.171111);
//	Point3D p1= new Point3D(34.819444,32.171111);
//	
//	double x = 34.819444 - 34.814167;
//	
//	Point3D p2 = new Point3D(x,0,0);
//	p2 = p2.GeoToMer();
//	
//	System.out.println("hi:  " +p2.x());
//	
//	double [] arr = c.azimuth_elevation_dist(p, p1);
//	
//	for (int i = 0; i < arr.length; i++) {
//		
//		System.out.println(arr[i]);
//		
//	}
//	
//	MyCoords c=new MyCoords();
//	Point3D p=new Point3D(34.814167, 32.171111 );
//	Point3D p1= new Point3D(34.814167,32.171111);
//
//	double dis = c.distance3d(p, p1);
//	
//	double rightAns = 500; // the real distance between the two points
//	
//System.out.println(dis);


//	
	MyCoords c=new MyCoords();

	Point3D p=new Point3D(34.814444 ,32.170833);
	Point3D p1= new Point3D(34.816667 ,32.175278); 

	Point3D v = c.vector3D(p, p1);
	Point3D rightAns = new Point3D(500,500);
	 System.out.println(v.toString());
	 System.out.println(rightAns.toString());
	
	
	}

}
