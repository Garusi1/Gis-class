package GIS1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.StringTokenizer;

import java.time.LocalDateTime;
import java.util.TimeZone;

import com.skedgo.converter.TimezoneMapper;

import Geom.Point3D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.FileWriter;



public class main1 {

	public static void main(String[] args) {
		//		// TODO Auto-generated method stub
		//
		//		String u = (TimezoneMapper.latLngToTimezoneString(32.103315, 35.209039));
		//		System.out.println(u);
		//	System.out.println(TimeZone.getTimeZone(u).getRawOffset()/(60*60*1000));
		//	
		//
		//	
		//	LocalDateTime ldt = LocalDateTime.now();
		//	
		//	Point3D ppp = new Point3D(32.109, 35.209039);
		//	MyGisElement p1 = new MyGisElement(ppp, "brown", "", "electric");
		//
		//Point3D pp = new Point3D(32.103315, 35.209039);
		//MyGisElement p = new MyGisElement(pp, "brown", "", "electric");
		//MyGisLayer mm = new MyGisLayer(p, "elelayer");
		////mm.add(p1);
		//
		//mm.GislayerToKML();


		String kmlstart = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n";

		//		        String kmlelement ="\t<Placemark>\n" +
		//		                            "\t<name>Simple placemark</name>\n" +
		//		                            "\t<description>"+name+"</description>\n" +
		//		                            "\t<Point>\n" +
		//		                            "\t\t<coordinates>"+latlon[1]+","+latlon[0]+","+z+ "</coordinates>\n" +
		//		                            "\t</Point>\n" +
		//		                            "\t</Placemark>\n";
		String kmlelement ="\t<Placemark>\n" +
				"\t<name>Simple placemark</name>\n" +
				"\t<description>kkk</description>\n" +
				"\t<Point>\n" +
				"\t\t<coordinates>32.333</coordinates>\n" +
				"\t</Point>\n" +
				"\t</Placemark>\n";

		String kmlend = "</kml>";

		ArrayList<String> content = new ArrayList<String>();
		content.add(0,kmlstart);
		content.add(1,kmlelement);
		content.add(2,kmlend);

		String kmltest = content.get(0) + content.get(1) + content.get(2);


		java.io.File testexists = new java.io.File("ye.kml");
		Writer fwriter;

		if(!testexists.exists()){
			try {

				fwriter = new FileWriter("yehuda.kml");
				fwriter.write(kmltest);
				fwriter.flush();
				fwriter.close();
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
		}

		else{

			//schleifenvariable
			String filecontent ="";

			ArrayList<String> newoutput = new ArrayList<String>();;

			try {
				BufferedReader in = new BufferedReader(new FileReader(testexists));
				while((filecontent = in.readLine()) !=null)

					newoutput.add(filecontent);

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			newoutput.add(2,kmlelement);

			String rewrite ="";
			for(String s : newoutput){
				rewrite += s;
			}

			try {
				fwriter  = new FileWriter("yehuda.kml");
				fwriter.write(rewrite);
				fwriter.flush();
				fwriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	


}


}
