package GIS1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import GIS1.MyGisElement;

import org.hamcrest.core.IsEqual;


public class MyGisLayer implements  GIS_layer {
/**
 * Gislayer - ArrayList of MyGisElements
 * data - meta - Data object
 * description
 */
	private ArrayList<MyGisElement> GisLayer;
	private MetaData data;
	private String description;
/**
 * constructors
 */

	public MyGisLayer() {
		ArrayList<MyGisElement> GisLayer = new ArrayList<MyGisElement>() ;
		data = new MetaData();
	}
	public MyGisLayer(MyGisElement e, String description1) {
		ArrayList<MyGisElement> GisLayer = new ArrayList<>() ;
		GisLayer.add(e);
		description = description1;
		data = new MetaData();
	}
	public MyGisLayer(ArrayList<MyGisElement> GisLayer1, String description1) {
		ArrayList<MyGisElement> GisLayer = GisLayer1 ;
		data = new MetaData();
		description = description1;
	}

	/**
	 * 
	 * @return the description
	 */
public String name() {
	return description;
}
/**
 * simple add Gis-element funtion 
 */
	
	public boolean add(GIS_element arg0) {
		// TODO Auto-generated method stub
		GisLayer.add((MyGisElement) arg0);
		return true;
	}

	/**
	 * add collection of GIS-elememts
	 */
	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		MyGisLayer p = (MyGisLayer) arg0;
		for(MyGisElement e:p.GisLayer)
			this.add(e);

		return true;
	}
//
	private MyGisElement GisLayer(GIS_element e) {
		return null;
		// TODO Auto-generated method stub
	}
	
	/**
	 * clear the object
	 */
	
	@Override
	public void clear() {
		GisLayer = null;
		description=null;
		data = null;
		// TODO Auto-generated method stub

	}

	@Override
	
	public boolean contains(Object arg0) {
	for (int i = 0; i < GisLayer.size(); i++) {
		if(GisLayer.get(i).IsEquals((MyGisElement)(arg0)));
		return true;
	}
		return false;
	}

	@Override
	/**
	 * @return true if the layer contains all the elements
	 */
	public boolean containsAll(Collection<?> arg0) {
		MyGisLayer p = (MyGisLayer) arg0;
		for (int i = 0; i < p.size(); i++) {
			
				if(p.GisLayer.contains(GisLayer.get(i))==false) {
					return false;
				
				
			}
			
		}
		return true;
	}
/**
 * @return true if the layer is empty
 */
	@Override
	public boolean isEmpty() {

		return GisLayer.isEmpty();
	}

//	@Override
////	public Iterator<MyGisElement> iterator() {
////		return GisLayer.iterator();
////
////	}
//
//	@Override
	/**
	 * removes an object from the layer
	 */
	public boolean remove(Object arg0) {
		Iterator<MyGisElement> iter=GisLayer.iterator();
		while(iter.hasNext()) {
			if(iter.next().equals((MyGisElement)(arg0))) {
				iter.remove();
				return true;
			}
		}
		
		
		return false;
	}

	/**
	 * removes Arraylist of gis-elements from the layer
	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		MyGisLayer p = (MyGisLayer) arg0;
		if(p.containsAll(this.GisLayer)) {
			for (int i = 0; i < p.size(); i++) {
				this.GisLayer.remove(p.GisLayer.get(i));
				return true;
				
			}
		}

		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the number of elements in the layer
	 */
	@Override
	public int size() {
		return GisLayer.size();

	}

	@Override
	public Object[] toArray() {
		
		
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return the meta Data of the layer
	 */

	@Override
	public Meta_data get_Meta_data() {

		return data;
	}
	/**
	 * gis layer to kml file function
	 * @return
	 */
	public String GislayerToKML(){
		
		String fileName = this.description+".kml";
		PrintWriter pw = null;
				
		try 
		{
			pw = new PrintWriter(new File(fileName));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return "err";
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version"+(char)34+"1.0"+(char)34+" encoding="+(char)34+"UTF-8"+(char)34+"?><kml xmlns="+(char)34+"http://www.opengis.net/kml/2.2"+(char)34+"><Document><Style id="+(char)34+"red"+(char)34+"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id="+(char)34+"yellow"+(char)34+"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id="+(char)34+"green"+(char)34+"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>"+this.description+"</name>");
//		for (Iterator<MyGisElement> iterator = GisLayer.iterator(); iterator.hasNext();) {
//			MyGisElement myGisElement = (MyGisElement) iterator.next();
		Iterator<MyGisElement> iter=GisLayer.iterator();
		while(iter.hasNext()) {
		
			
//		sb.append("<Placemark><name><![CDATA["+e.getdata()+"]]></name><description><![CDATA[color: <b>"+e.getcolor()+"</b><br/>Capabilities: <b>null</b><br/>Frequency: <b>2412</b><br/>Timestamp: <b>1512117845000</b><br/>Date: <b>2017-12-01 10:44:05</b>]]></description><styleUrl>#red</styleUrl>			<Point>			<coordinates>34.81190851897319,32.17188758190333</coordinates></Point>			</Placemark>");
		sb.append("<Placemark><name><![CDATA["+iter.next().getdata()+"]]></name><description><![CDATA[color: <b>"+iter.next().getcolor()+"</b><br/>Capabilities: <b>null</b<br/>Date: <b>"+iter.next().getTime()+"</b>]]></description><styleUrl>#red</styleUrl>			<Point>			<coordinates>"+iter.next().getPoint2d()+"</coordinates></Point>			</Placemark>");
}

		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
		return"done";
	}
	/**
	 * Iterator
	 */
	@Override
	public Iterator<GIS_element> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


}