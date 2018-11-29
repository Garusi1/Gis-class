package File_format;
import GIS1.GIS_element;
import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import Geom.Point3D;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVWriter 
{
	public static void main(String[] args)
	{
		Point3D ppp = new Point3D(32.109, 35.209039);
		MyGisElement p1 = new MyGisElement(ppp, "brown", "");

	Point3D pp = new Point3D(32.103315, 35.209039);
	MyGisElement p = new MyGisElement(pp);
	MyGisLayer mm = new MyGisLayer(p, "elelayer");
	mm.add(p);
	
		MyGisLayer m = new MyGisLayer();
		String fileName = "yehuda131.kml";
		PrintWriter pw = null;
		String s = " "+(char)34;
		System.out.println(s);
		
		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version"+(char)34+"1.0"+(char)34+" encoding="+(char)34+"UTF-8"+(char)34+"?><kml xmlns="+(char)34+"http://www.opengis.net/kml/2.2"+(char)34+"><Document><Style id="+(char)34+"red"+(char)34+"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id="+(char)34+"yellow"+(char)34+"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id="+(char)34+"green"+(char)34+"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>yehuda</name>");

//		sb.append("<Placemark><name><![CDATA[electric]]></name><description><![CDATA[color: <b>brown</b>	<Point>			<coordinates>"+p.getPoint2d()+"</coordinates></Point>			</Placemark>");
//		sb.append("<Placemark><name><![CDATA[electric]]></name><description><![CDATA[color: <b>brown</b><br/>Capabilities: <b>null</b<br/>Date: <b>"+p.getTime()+"</b>]]></description><styleUrl>#red</styleUrl>			<Point>			<coordinates>"+p.getPoint2d()+"</coordinates></Point>			</Placemark>");

//		for () {
//			
//		}

		sb.append("<coordinates>");
		sb.append("</Placemark>");
		sb.append("<timing>");
		sb.append("<color>");
		sb.append("<UTC>");
		sb.append("<data>");
		sb.append("<id>");
		sb.append(',');
		sb.append("Name");
		sb.append("<br/>Date: <b></b>]]>");
		sb.append('\n');
		
		
		
		sb.append("32.33333,33.22222");
		sb.append(',');
		sb.append(',');
		sb.append(',');
		sb.append("4324");
		sb.append(',');

		sb.append("Israel Israeli");
		sb.append(',');
		sb.append("2017-12-01 10:50:59");

		
		sb.append('\n');

		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
	}
}




