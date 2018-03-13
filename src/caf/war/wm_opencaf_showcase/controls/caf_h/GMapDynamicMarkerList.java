package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.data.object.SelectableListTableContentProvider;

@ManagedBean(name="gmapDynamicMarkerListBean")
@javax.faces.bean.SessionScoped
@ExpireWithPageFlow
public class GMapDynamicMarkerList extends GMap {
    
    protected SelectableListTableContentProvider dynamicMarkers;
    
    
    public GMapDynamicMarkerList() {
		super();
		//start with some reasonable defaults for the map positioning
		address = null;
	    latitude = 37.09024;
	    longitude = -95.712891;
	    zoom = 3;
	    mapType = "G_NORMAL_MAP";
	}

	public SelectableListTableContentProvider getDynamicMarkers() {
        if (dynamicMarkers == null) {
            dynamicMarkers = new SelectableListTableContentProvider(new ArrayList<MyMarker>(Arrays.asList(
                    new MyMarker("Charleston, SC", 32.793053, -79.941294),
                    new MyMarker("St. Paul, MN", 44.944627, -93.102665),
                    new MyMarker("Las Vegas, NV", 36.233048, -115.246776)
            		)), "#{marker.address}", "marker");
            dynamicMarkers.setRowType(MyMarker.class);
        }
        return dynamicMarkers;
    }
    
    @SuppressWarnings("unchecked")
	public List<MyMarker> getDynamicMarkersReadOnly() {
        return getDynamicMarkers().getList();
    }
    
    public static class MyMarker implements Serializable {
		private static final long serialVersionUID = 2576805222825995522L;
		protected String address;
        protected Double latitude;
        protected Double longitude;
        
        public MyMarker() {
            //
        }
        
        public MyMarker(String address) {
            this();
            setAddress(address);
        }
        
        public MyMarker(String address, double latitude, double longitude) {
            this(address);
            setLatitude(latitude);
            setLongitude(longitude);
        }
        
        public String getAddress() {
            return address;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public Double getLatitude() {
            return latitude;
        }
        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }
        public Double getLongitude() {
            return longitude;
        }
        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
        
        public boolean isSelected() {
            FacesContext context = FacesContext.getCurrentInstance();
    		ELContext elContext = context.getELContext();
    		ExpressionFactory expressionFactory = context.getApplication().getExpressionFactory();
    		ValueExpression ve = expressionFactory.createValueExpression(elContext, 
    				"#{gmapDynamicMarkerListBean.dynamicMarkers}", 
    				SelectableListTableContentProvider.class);
            
            SelectableListTableContentProvider provider = (SelectableListTableContentProvider)ve.getValue(elContext);
            return provider.getRowSelectedIds().contains(getAddress());
        }
    }
}
