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

/**
 * 
 * This class represents a collection of GIS-ELEMENTS.
 * 
 * @author Naor and Michael
 *
 */

public class MyGisLayer implements  GIS_layer {
	/**
	 * Gislayer - ArrayList of MyGisElements
	 * data - meta-Data object
	 * description
	 */
	private ArrayList< GIS_element> GisLayer;
	private MetaData data;
	private String description;
	/**
	 *  Partial constructor that gets the description of the layer 
	 */


	public MyGisLayer(String des) {
		GisLayer = new ArrayList<GIS_element>() ;
		data = new MetaData();
		this.description=des;
	}
	/**
	 * full constructor that gets the description of the layer, and a GIS element 
	 */

	public MyGisLayer(MyGisElement e, String description1) {
		GisLayer = new ArrayList<GIS_element>() ;
		GisLayer.add(e);
		description = description1;
		data = new MetaData();
	}
	/**
	 * full constructor that gets the description of the layer, and a collection of elements 
	 */

	public MyGisLayer(ArrayList<GIS_element> GisLayer1, String description1) {
		GisLayer = new ArrayList<GIS_element>() ;
		GisLayer = GisLayer1 ;
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
	 * simple add Gis-element function 
	 * @return true while succeed adding
	 */

	public boolean add(GIS_element arg0) {
		GisLayer.add((MyGisElement)arg0);
		return true;


	}

	/**
	 * add collection of GIS-elememts
	 * @return true while succeed adding
	 */
	@Override

	public boolean addAll(Collection<? extends GIS_element> arg0) {

		if(arg0.isEmpty()==false) {
			Iterator<GIS_element> iter=(Iterator<GIS_element>) arg0.iterator();
			while(iter.hasNext()) {
				MyGisElement e=(MyGisElement) iter.next();
				GisLayer.add(e);

			}
			return true;
		}
		return false;
	}
	private MyGisElement GisLayer(GIS_element e) {
		return (MyGisElement) e;
		// TODO Auto-generated method stub
	}

	/**
	 * clear the object
	 */

	@Override
	public void clear() {
		GisLayer.clear();
		description=null;
		data = null;
		// TODO Auto-generated method stub

	}
	/**
	 * check if the element exist in the layer
	 * @return true if exist
	 */

	@Override

	public boolean contains(Object arg0) {
		for (int i = 0; i < GisLayer.size(); i++) {
			if(((MyGisElement) GisLayer.get(i)).IsEquals((MyGisElement)(arg0))==true) {
				return true;
			}
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
		if(GisLayer.isEmpty()==true) {
			return true;
		}

		return false;
	}



	@Override
	/**
	 *  removes an object from the layer
	 *  @return true if succeed
	 */
	public boolean remove(Object arg0) {
		Iterator<GIS_element> iter=GisLayer.iterator();
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
	 * 	 *  @return true if succeed

	 */
	@Override
	public boolean removeAll(Collection<?> arg0) {
		if(arg0.isEmpty()==false) {

			Iterator<GIS_element> iter=(Iterator<GIS_element>) arg0.iterator();
			while(iter.hasNext()) {
				remove(iter.next());
			}
			return true;
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
	 * @return the description of the layer
	 */

	public String getDes() {
		return description;
	}
	
	/**
	 * @return the arraylist of the layer
	 */
	public ArrayList<GIS_element> getArrayList() {
		return GisLayer;
	}
	/**
	 * Iterator
	 */

	@Override
	public Iterator<GIS_element> iterator() {
		return GisLayer.iterator();

	}



}