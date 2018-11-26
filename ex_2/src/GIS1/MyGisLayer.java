package GIS1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyGisLayer implements  GIS_layer {

	Collection<MyGisElement> gisLayer ;
	private String data;
	
	
	public MyGisLayer() {
		Collection<MyGisElement> gisLayer ;
		data = null;
	}
	public MyGisLayer(MyGisElement e, String data1) {
		Collection<MyGisElement> gisLayer = null ;
		gisLayer.add(e);
		data = data1;
	}
	public MyGisLayer(Collection<MyGisElement> gisLayer1, String data1) {
		Collection<MyGisElement> gisLayer = gisLayer1 ;
		data = data1;
	}
	
	
	public boolean add(GIS_element arg0) {
		// TODO Auto-generated method stub
		gisLayer.add((MyGisElement) arg0);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		MyGisLayer p = (MyGisLayer) arg0;
		for(GIS_element e: p ) {
			gisLayer.add(p.gisLayer.);
		}
		return false;
	}

	@Override
	public void clear() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<GIS_element> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
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
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
