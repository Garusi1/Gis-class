/*
 * 
 */
package GIS1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * This class represent a collection of GisLayers.
 *
 * @author naor eliav and michael garusi
 */


public class MyGisProject implements GIS_project{
	
	/** gisProject - ArrayList of MyGislayers data - meta - Data object description. */
	
	private ArrayList<GIS_layer> gisProject;
	
	/** The Projec data. */
	private MetaData ProjecData;
	
	/** The Project description. */
	private String ProjectDescription;
	
	/**
	 * Default constructor.
	 */
	public MyGisProject() {
	    gisProject=  new ArrayList<GIS_layer>() ;
;
		ProjecData = new MetaData();
	}
	
	/**
	 *  constructor that gets description.
	 *
	 * @param description1 the description 1
	 */
public MyGisProject(String description1) {
	    gisProject=  new ArrayList<GIS_layer>() ;
		ProjectDescription = description1;

		ProjecData = new MetaData();
	}
	
	/**
	 *  constructor that gets layer add it to the collection and description.
	 *
	 * @param A_L the a l
	 * @param description1 the description 1
	 */
	
	
	public MyGisProject(MyGisLayer A_L, String description1) {
		 gisProject = new ArrayList<GIS_layer>() ;
		gisProject.add(A_L);
		ProjectDescription = description1;
		ProjecData = new MetaData();
	}
	
	/**
	 *  constructor that gets list of layer and description.
	 *
	 * @param gisLayer1 the gis layer 1
	 * @param description1 the description 1
	 */
	public MyGisProject(ArrayList<MyGisLayer> gisLayer1, String description1) {
		 gisProject = new ArrayList<GIS_layer>() ;
		ProjecData = new MetaData();
		ProjectDescription = description1;
	}

	
	/* (non-Javadoc)
	 * @see java.util.Set#add(java.lang.Object)
	 */
	@Override
	/**
	 *  This function add GisLayer to the collection
	 *  @return true if succeeded
	 */
	public boolean add(GIS_layer e) {
		
		gisProject.add((MyGisLayer)e);
		return  true;
	}

	/* (non-Javadoc)
	 * @see java.util.Set#addAll(java.util.Collection)
	 */
	@Override
	/**
	 *  This function add GisLayer collection to the current collection collection
	 *  @return true if succeeded
	 */
	public boolean addAll(Collection<? extends GIS_layer> c) {
		if(c.isEmpty()==false) {
			Iterator<GIS_layer> iter=(Iterator<GIS_layer>) c.iterator();
			while(iter.hasNext()) {
				MyGisLayer e=(MyGisLayer) iter.next();
				gisProject.add(e);
				
			}
			return true;
			}
			return false;	}

	/* (non-Javadoc)
	 * @see java.util.Set#clear()
	 */
	@Override
	/**
	 *  This function delete all the gislayers from the 
	 *  collection and make ProjecData and ProjectDescription null.
	 */
	public void clear() {
		gisProject.clear();
		ProjecData=null;
		ProjectDescription=null;
		
	}

	/* (non-Javadoc)
	 * @see java.util.Set#contains(java.lang.Object)
	 */
	@Override
	/**
	 *  This function checks if the the gislayer exist in the collection.
	 *  @return true if exist.
	 *  else return false.
	 **/	
	public boolean contains(Object o) {
		
		if(gisProject.contains((MyGisLayer)o)) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Set#containsAll(java.util.Collection)
	 */
	@Override
	/**
	 *  This function checks if the the current collection contains c collection.
	 *  @return true if contain.
	 *  else return false.
	 **/	
	public boolean containsAll(Collection<?> c) {

		
		if(c.size()>gisProject.size()) {
			return false;
		}
		else {
			Iterator<GIS_layer> iter=(Iterator<GIS_layer>) c.iterator();
			while(iter.hasNext()) {
				if(contains(iter.next())==false) {
					return false;
				}
			}

			
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.util.Set#isEmpty()
	 */
	@Override
	/**
	 *  This function checks if the current collection is empty.
	 *  @return true if it's empty.
	 *  else return false.
	 **/	
	public boolean isEmpty() {
		return (gisProject.isEmpty());
	}

	/* (non-Javadoc)
	 * @see java.util.Set#iterator()
	 */
	@Override
	/**
	 *  This function return iterator of the collection. 
	 **/	
	public Iterator<GIS_layer> iterator() {
		return gisProject.iterator();
	}

	/* (non-Javadoc)
	 * @see java.util.Set#remove(java.lang.Object)
	 */
	@Override
	/**
	 *  This function remove the the gislayer o from the collection. 
	 *  @return true if it removes.
	 *  else return false.
	 **/	
	public boolean remove(Object o) {
		Iterator<GIS_layer> iter=gisProject.iterator();
		while(iter.hasNext()) {
			if(contains(o)==true) {
				iter.remove();
				return true;
			}
		}
		
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Set#removeAll(java.util.Collection)
	 */
	@Override
	/**
	 *  This function remove the the gislayer collection c from the current  collection. 
	 *  @return true if it removes.
	 *  else return false.
	 **/	
	public boolean removeAll(Collection<?> c) {
		Iterator<GIS_layer> iter=(Iterator<GIS_layer>) c.iterator();
		while(iter.hasNext()) {
			remove(iter.next());
		}
return true;
		
		
	}

	

	/* (non-Javadoc)
	 * @see java.util.Set#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return gisProject.retainAll(c);
	}

	/* (non-Javadoc)
	 * @see java.util.Set#size()
	 */
	@Override
	/**
	 *  This function return the size of the collecion
	 *  @return the size of the collection
	 *  
	 **/	
	public int size() {
		return gisProject.size();
	}

	/* (non-Javadoc)
	 * @see java.util.Set#toArray()
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return gisProject.toArray();
	}

	/* (non-Javadoc)
	 * @see java.util.Set#toArray(java.lang.Object[])
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return gisProject.toArray(a);
	}

	/* (non-Javadoc)
	 * @see GIS1.GIS_project#get_Meta_data()
	 */
	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return ProjecData;
	}
	
	

}