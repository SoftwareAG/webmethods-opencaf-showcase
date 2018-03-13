package caf.war.wm_opencaf_showcase.controls.mws_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.portal.framework.impl.PortalServlet;
import com.webmethods.portal.framework.presentation.PresentationData;
import com.webmethods.portal.service.meta2.thing.IThingID;
import com.webmethods.portal.system.IURI;

@ManagedBean(name="contextUpdaterBean")
@SessionScoped
@ExpireWithPageFlow
public class ContextUpdater extends BaseFacesBean {
	
	/**
	 * Returns true if the MWS page is a workspace
	 */
	public boolean isWorkspace() {
		boolean isWorkspace = false;
		HttpServletRequest currentRequest = PortalServlet.getCurrentRequest();
		if (currentRequest != null) {
			PresentationData presentationData = PresentationData.getPresentationData(currentRequest);
			IURI resourceURI = presentationData.getResourceURI();
			if (resourceURI instanceof IThingID) {
				IThingID thingID = (IThingID)resourceURI;
				int xTypeID = thingID.getXTypeID();
				String xTypeName = thingID.getMetaContext().getXTypeService().getXTypeName(xTypeID);
				isWorkspace = "wm_xt_workspace".equals(xTypeName);
			}
		}
		return isWorkspace;
	}

}
