package GIS1;

import java.util.TimeZone;

import com.skedgo.converter.TimezoneMapper;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String u = (TimezoneMapper.latLngToTimezoneString(32.103315, 35.209039));
		System.out.println(u);
	System.out.println(TimeZone.getTimeZone(u).getRawOffset()/(60*60*1000));
	
	
	}
	

}
