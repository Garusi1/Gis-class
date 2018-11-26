package GIS1;

import java.time.LocalDateTime;
import java.util.TimeZone;

import com.skedgo.converter.TimezoneMapper;
import com.skedgo.generator.TimeZoneMapperConverter;

import Geom.Point3D;

public class MetaData implements Meta_data{

	public long utc;
	public String  utcName;
	public LocalDateTime ldt;
	
	public LocalDateTime correntTime (MyGisElement p) { // returns the Utc number for example: israel = 2
		LocalDateTime ldt = LocalDateTime.now();
		return ldt;
	}
	
	public long getUTC(MyGisElement p) { // returns the Utc number for example: israel = 2

		String u = (TimezoneMapper.latLngToTimezoneString(p.getPoint().x(), p.getPoint().y()));

		long UtcLocation = TimeZone.getTimeZone(u).getRawOffset()/(60*60*1000);
		
		return UtcLocation;
	}
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
		return 0;
	}
	public String toString () {
		String s = this.utcName +", "+this.utc;
		return s;
	}

}
