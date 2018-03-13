package caf.war.wm_opencaf_showcase.controls.f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name = "metadataBean")
@SessionScoped
public class MetadataBean extends BaseFacesBean {
	private String emptyValue = "";

	public String getEmptyValue() {
		return emptyValue;
	}

	public void setEmptyValue(String emptyValue) {
		this.emptyValue = emptyValue;
	}
}
