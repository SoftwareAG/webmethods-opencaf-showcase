package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="gmapBean")
@javax.faces.bean.SessionScoped
@ExpireWithPageFlow
public class GMap extends BaseFacesBean {
    protected String gmapsApiKey;
    protected String address = "800 Occidental Ave S, Seattle, WA 98134";
    protected Double latitude;
    protected Double longitude;
    protected Integer zoom = 17;
    protected String mapType = "G_SATELLITE_MAP";
    
    public String getGmapsApiKey() {
        return gmapsApiKey;
    }
    
    public void setGmapsApiKey(String value) {
        gmapsApiKey = value;
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

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType;
    }

    

    // ---- fields bound to the map control, read-only since we don't need 
    //  the current map values to be posted back to the server with commands
    public Double getLatitudeReadOnly() {
        return latitude;
    }
    public Double getLongitudeReadOnly() {
        return longitude;
    }
    public Integer getZoomReadOnly() {
        return zoom;
    }
    public String getMapTypeReadOnly() {
        return mapType;
    }

}
