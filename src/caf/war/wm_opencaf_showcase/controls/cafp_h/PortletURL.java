package caf.war.wm_opencaf_showcase.controls.cafp_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.portlet.IPortletURL;
import com.webmethods.caf.portlet.PortletURLFactory;

@ManagedBean(name="porletUrlBean")
@SessionScoped
@ExpireWithPageFlow
public class PortletURL extends BaseFacesBean {
	
	public String getLinkToShowcasePage() {
		String link = null;
		try {
			//create a new render url
			IPortletURL portletUrl = PortletURLFactory.createRenderUrl(getFacesContext());
			
			//clear any state leftover from the current request
			portletUrl.clearState();
			
			//set the base URL to the page the link should go to
			portletUrl.setBaseURL("/folder.wm_opencaf_showcase");
			
			//convert the object to a string.
			link = portletUrl.toString();
		} catch (Throwable t) {
			error(t);
		}
		return link;
	}

}
