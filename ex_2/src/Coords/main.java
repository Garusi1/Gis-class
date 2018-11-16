package Coords;

import Geom.Point3D;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Geo2UTM geo = new Geo2UTM (32.22222, 33.33333);
		double utmx  = geo.Easting;
		double utmy = geo.Northing;
		double zone = geo.Zone;
		System.out.println("y= " +utmy + " x= " +utmx +" zone= " +zone);
		
		String s = ("36"+" "+"north" +" "+utmx +" "+utmy );
		System.out.println(s);
		UTM2Geo utm = new UTM2Geo(s);
		
		double geox= utm.longitude;
		double geoy= utm.latitude;
		
		System.out.println("y= "+geoy +" x= " +geox );
		
		System.out.println();
		
		
		
		System.out.println();

	}

}
