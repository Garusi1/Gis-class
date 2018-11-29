package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import GIS1.MyGisElement;
import GIS1.MyGisLayer;
import Geom.Point3D;

public class CSVReader {

    public static void main(String[] args) 
    {
    	

        String csvFile = "WigleWifi_20171201110209.csv";
        String line = "";
        String cvsSplitBy = ",";
        MyGisLayer L= new MyGisLayer();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
        {
        	line = br.readLine();
            while ((line = br.readLine()) != null) 
            {
                String[] userInfo = line.split(cvsSplitBy);
                
              Point3D p = new Point3D ((Double.parseDouble(userInfo[0])),(Double.parseDouble(userInfo[1])),(Double.parseDouble(userInfo[2])));
              MyGisElement pp = new MyGisElement(p, userInfo[3],userInfo[5], userInfo[6], "", Long.parseLong(userInfo[4]));
              L.add(pp);
              System.out.println();
             // System.out.println(L.isEmpty()); 
              ;
                System.out.println("X: " + userInfo[0] + " , Y: " + userInfo[1] +
                		" z: " + userInfo[2] + " ,timing: " + userInfo[3]+ " ,UTC zone: "
                				+ ""+ userInfo[4]+ " ,data: "+ userInfo[5]+ " ,description: "+ userInfo[6]);
            }

        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}