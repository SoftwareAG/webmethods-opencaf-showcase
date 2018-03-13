package caf.war.wm_opencaf_showcase.controls.mws_h;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.portal.PortalItemModel;

@ManagedBean(name="resourcePickerBean")
@SessionScoped
@ExpireWithPageFlow
public class ResourcePicker extends BaseFacesBean {

	private PortalItemModel resource;
	private List<PortalItemModel> resources;
	
	public PortalItemModel getResource() {
		return resource;
	}
	public void setResource(PortalItemModel resource) {
		this.resource = resource;
	}
	public List<PortalItemModel> getResources() {
		return resources;
	}
	public void setResources(List<PortalItemModel> resources) {
		this.resources = resources;
	}
}
