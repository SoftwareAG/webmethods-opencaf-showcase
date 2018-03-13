package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;

@ManagedBean(name="gmapMarkerBean")
@javax.faces.bean.SessionScoped
@ExpireWithPageFlow
public class GMapMarker extends GMap {
    
    protected Boolean markerOneSelected;
    protected Double markerOneLatitude;
    protected Double markerOneLongitude;
    
    public GMapMarker() {
		super();
		//start with some reasonable defaults for the map positioning
		address = null;
	    latitude = 37.09024;
	    longitude = -65.712891;
	    zoom = 3;
	    mapType = "G_NORMAL_MAP";
	}
    
    public Boolean getMarkerOneSelected() {
        return markerOneSelected;
    }

    public void setMarkerOneSelected(Boolean markerOneSelected) {
        this.markerOneSelected = markerOneSelected;
    }

    public Double getMarkerOneLatitude() {
        return markerOneLatitude;
    }

    public void setMarkerOneLatitude(Double markerOneLatitude) {
        this.markerOneLatitude = markerOneLatitude;
    }

    public Double getMarkerOneLongitude() {
        return markerOneLongitude;
    }

    public void setMarkerOneLongitude(Double markerOneLongitude) {
        this.markerOneLongitude = markerOneLongitude;
    }
    
}
