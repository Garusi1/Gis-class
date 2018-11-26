package GIS1;

import java.util.TimeZone;

import com.skedgo.converter.TimezoneMapper;

import Geom.Point3D;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String u = (TimezoneMapper.latLngToTimezoneString(32.103315, 35.209039));
		System.out.println(u);
	System.out.println(TimeZone.getTimeZone(u).getRawOffset()/(60*60*1000));
	
	Point3D pp = new Point3D(32.2222,33.2222);
	MyGisElement p = new MyGisElement(pp, "fds", "","");
	System.out.println(p.toString());
	
	}
	

}
