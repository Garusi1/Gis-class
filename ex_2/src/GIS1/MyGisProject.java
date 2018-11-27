package GIS1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyGisProject implements GIS_project{

	
	private ArrayList<MyGisLayer> gisProject;
	private MetaData ProjecData;
	private String ProjectDescription;
	
	public MyGisProject() {
		ArrayList<MyGisLayer> gisProject ;
		ProjecData = new MetaData();
	}
	public MyGisProject(MyGisLayer A_L, String description1) {
		ArrayList<MyGisLayer> gisProject = new ArrayList<>() ;
		gisProject.add(A_L);
		ProjectDescription = description1;
		ProjecData = new MetaData();
	}
	public MyGisProject(ArrayList<MyGisLayer> gisLayer1, String description1) {
		ArrayList<MyGisLayer> gisProject =  new ArrayList<>() ;
		ProjecData = new MetaData();
		ProjectDescription = description1;
	}

	
	@Override
	public boolean add(GIS_layer e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
