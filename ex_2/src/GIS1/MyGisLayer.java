package GIS1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.hamcrest.core.IsEqual;

public class MyGisLayer implements  GIS_layer {

	private ArrayList<MyGisElement> GisLayer;
	private MetaData data;
	private String description;


	public MyGisLayer() {
		ArrayList<MyGisElement> GisLayer = new ArrayList<>() ;
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


	public boolean add(GIS_element arg0) {
		// TODO Auto-generated method stub
		GisLayer.add((MyGisElement) arg0);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		MyGisLayer p = (MyGisLayer) arg0;
		for(MyGisElement e:p.GisLayer)
			this.add(e);

		return true;
	}

	private MyGisElement GisLayer(GIS_element e) {
		return null;
		// TODO Auto-generated method stub
	}
	@Override
	public void clear() {
		GisLayer = null;
		description=null;
		data = null;
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		MyGisLayer p = (MyGisLayer) arg0;
//		for(MyGisElement e:p.GisLayer)
//			e IsEqual;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {

		return GisLayer.isEmpty();
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

	@Override
	public Meta_data get_Meta_data() {

		return data;
	}


}
