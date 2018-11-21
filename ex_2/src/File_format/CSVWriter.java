package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVWriter 
{
	public static void main(String[] args)
	{
		String fileName = "output.csv";
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
		sb.append("id");
		sb.append(',');
		sb.append("Name");
		sb.append('\n');
		
		sb.append("1");
		sb.append(',');
		sb.append("Israel Israeli");
		sb.append('\n');

		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
	}
}




