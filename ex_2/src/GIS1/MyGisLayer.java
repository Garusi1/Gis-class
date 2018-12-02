/*
 * 
 */
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

// TODO: Auto-generated Javadoc
/**
 * 
 * This class represents a collection of GIS-ELEMENTS.
 * 
 * @author Naor and Michael
 *
 */

public class MyGisLayer implements  GIS_layer {
	
	/** Gislayer - ArrayList of MyGisElements data - meta-Data object description. */
	private ArrayList< GIS_element> GisLayer;
	
	/** The data. */
	private MetaData data;
	
	/** The description. */
	private String description;
	
	/**
	 *  Partial constructor that gets the description of the layer.
	 *
	 * @param des the des
	 */


	public MyGisLayer(String des) {
		GisLayer = new ArrayList<GIS_element>() ;
		data = new MetaData();
		this.description=des;
	}
	
	/**
	 * full constructor that gets the description of the layer, and a GIS element.
	 *
	 * @param e the e
	 * @param description1 the description 1
	 */

	public MyGisLayer(MyGisElement e, String description1) {
		GisLayer = new ArrayList<GIS_element>() ;
		GisLayer.add(e);
		description = description1;
		data = new MetaData();
	}
	
	/**
	 * full constructor that gets the description of the layer, and a collection of elements.
	 *
	 * @param GisLayer1 the gis layer 1
	 * @param description1 the description 1
	 */

	public MyGisLayer(ArrayList<GIS_element> GisLayer1, String description1) {
		GisLayer = new ArrayList<GIS_element>() ;
		GisLayer = GisLayer1 ;
		data = new MetaData();
		description = description1;
	}

	/**
	 * Name.
	 *
	 * @return the description
	 */
	public String name() {
		return description;
	}
	
	/**
	 * simple add Gis-element function .
	 *
	 * @param arg0 the arg 0
	 * @return true while succeed adding
	 */

	public boolean add(GIS_element arg0) {
		GisLayer.add((MyGisElement)arg0);
		return true;


	}

	/**
	 * add collection of GIS-elememts.
	 *
	 * @param arg0 the arg 0
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
	
	/**
	 * Gis layer.
	 *
	 * @param e the e
	 * @return the my gis element
	 */
	private MyGisElement GisLayer(GIS_element e) {
		return (MyGisElement) e;
		// TODO Auto-generated method stub
	}

	/**
	 * clear the object.
	 */

	@Override
	public void clear() {
		GisLayer.clear();
		description=null;
		data = null;
		// TODO Auto-generated method stub

	}
	
	/**
	 * check if the element exist in the layer.
	 *
	 * @param arg0 the arg 0
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

	/* (non-Javadoc)
	 * @see java.util.Set#containsAll(java.util.Collection)
	 */
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
	 * Checks if is empty.
	 *
	 * @return true if the layer is empty
	 */
	@Override
	public boolean isEmpty() {
		if(GisLayer.isEmpty()==true) {
			return true;
		}

		return false;
	}



	/* (non-Javadoc)
	 * @see java.util.Set#remove(java.lang.Object)
	 */
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
	 * 	 *  @return true if succeed.
	 *
	 * @param arg0 the arg 0
	 * @return true, if successful
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

	/* (non-Javadoc)
	 * @see java.util.Set#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return GisLayer.retainAll(arg0);
	}

	/**
	 * Size.
	 *
	 * @return the number of elements in the layer
	 */
	@Override
	public int size() {
		return GisLayer.size();

	}

	/* (non-Javadoc)
	 * @see java.util.Set#toArray()
	 */
	@Override
	public Object[] toArray() {


		return GisLayer.toArray();
	}

	/* (non-Javadoc)
	 * @see java.util.Set#toArray(java.lang.Object[])
	 */
	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return GisLayer.toArray(arg0);
	}
	
	/**
	 * Gets the meta data.
	 *
	 * @return the meta Data of the layer
	 */

	@Override
	public Meta_data get_Meta_data() {

		return data;
	}
	
	/**
	 * Gets the des.
	 *
	 * @return the description of the layer
	 */

	public String getDes() {
		return description;
	}
	
	/**
	 * Gets the array list.
	 *
	 * @return the arraylist of the layer
	 */
	public ArrayList<GIS_element> getArrayList() {
		return GisLayer;
	}
	
	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */

	@Override
	public Iterator<GIS_element> iterator() {
		return GisLayer.iterator();

	}



}