package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Geom.Point3D;

public class CSVReader {

    public static void main(String[] args) 
    {
    	
    	System.out.println("fbhdsfghdsj");
        String csvFile = "WigleWifi_20171203085618.csv";
        String line = "";
        String cvsSplitBy = ",";
int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
        	
        }
            while ((line = br.readLine()) != null) 
            {
//                Point3D p = (Double.parseDouble(userInfo[0]),(Double.parseDouble(userInfo[1]))
            	
            	String[] userInfo = line.split(cvsSplitBy);

                System.out.println("x," + userInfo[0] + "y" + userInfo[1] +
                		" Phone: " + userInfo[2] + " Country: " + userInfo[3] );
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
//        }

    }

}