package GIS1;

import java.time.LocalDateTime;
import java.util.TimeZone;

import com.skedgo.converter.TimezoneMapper;
import com.skedgo.generator.TimeZoneMapperConverter;

import Geom.Point3D;

/**
 * meta Data class
 * 
 * contains meta-Data about GIS objects 
 * @author mgaru
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
	 * 
	 * @param p
	 * @return corrent Time
	 */
	public LocalDateTime correntTime (MyGisElement p) { // returns the Utc number for example: israel = 2
		LocalDateTime ldt = LocalDateTime.now();
		return ldt;
	}
	/**
	 * 
	 * @param p
	 * @returns the Utc zone for example: israel = 2
	 */
	
	public long getUTC(MyGisElement p) { // returns the Utc number for example: israel = 2

		String u = (TimezoneMapper.latLngToTimezoneString(p.getPoint().x(), p.getPoint().y()));

		long UtcLocation = TimeZone.getTimeZone(u).getRawOffset()/(60*60*1000);
		
		return UtcLocation;
	}
	/**
	 * 
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
	public long getUTC() {
		// TODO Auto-generated method stub
		return utc;
	}
	public String toString () {
		String s = this.utcName +", "+this.utc+", "+this.ldt.toString();
		return s;
	}

}
