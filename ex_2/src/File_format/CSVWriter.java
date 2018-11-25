package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVWriter 
{
	public static void main(String[] args)
	{
		String fileName = "output111.kml";
		PrintWriter pw = null;
		
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
		sb.append("<coordinates>");
		sb.append("</Placemark>");
		sb.append("<Placemark>");

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




