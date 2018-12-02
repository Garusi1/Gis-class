package GIS1;

import java.time.LocalDateTime;
import java.util.TimeZone;

import com.skedgo.converter.TimezoneMapper;
import com.skedgo.generator.TimeZoneMapperConverter;

import Geom.Point3D;

/**
 * meta Data class
 * 
 * contains meta-Data(information) about GIS objects 
 * @author naor eliav and michae garusi.
 *
 */

public class MetaData implements Meta_data{
/**
 * utc - time-zone of GIS object
 * utcName - time-zone location of GIS object (for example - Israel/jerusalem)
 *  ldt - correntTime  of GIS object
 */
	public long utc;
	public String  utcName;
	public LocalDateTime ldt;
		
	/**
	 * constructor
	 */
	public MetaData () {
		ldt = LocalDateTime.now();
	}
	/**
	 * This fuction return the corrent time.
	 * @param p
	 * @return corrent Time
	 */
	public String correntTime (MyGisElement p) { // returns the Utc number for example: israel = 2
		LocalDateTime ldt = LocalDateTime.now();
		String ldt1 = ldt.toString();
		return ldt1;
	}
	/**
	 * This function gets giselement and return it's UTC Zone
	 * @param p
	 * @returns the Utc zone for example: israel = 2
	 */
	
	public long getUTC(MyGisElement p) { // returns the Utc number for example: israel = 2

		String u = (TimezoneMapper.latLngToTimezoneString(p.getPoint().x(), p.getPoint().y()));

		long UtcLocation = TimeZone.getTimeZone(u).getRawOffset()/(60*60*1000);
		
		return UtcLocation;
	}
	/**
	 * This function gets the GisElement object and return it's location.
	 * @param p
	 * @return  time-zone location of GIS object (for example - Israel/jerusalem)
	 */
	public String getUTCLocation(MyGisElement p) {

		String u = (TimezoneMapper.latLngToTimezoneString(p.getPoint().x(), p.getPoint().y()));
			
			return u;
		}
	@Override
	public Point3D get_Orientation() {
return null;
	}
	@Override
	/**
	 * This function return utc
	 * @return  utc
	 */
	public long getUTC() {
		// TODO Auto-generated method stub
		return utc;
	}
	/**
	 * This function return string
	 * @return  string
	 */
	public String toString () {
		String s = this.utcName +", "+this.utc+", "+this.ldt.toString();
		return s;
	}

}