package caf.war.wm_opencaf_showcase;

import java.io.IOException;
import java.io.InputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.webmethods.caf.common.StringTools;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.portal.service.meta2.thing.IThingID;
import com.webmethods.portal.system.IURI;
import com.webmethods.portal.system.PortalSystem;

@ManagedBean(name="samplesBean")
@RequestScoped
public class SamplesBean extends BaseFacesBean {
	
	public String webResource(String resourcePath) {
		InputStream resourceAsStream = null;
		try {
			resourceAsStream = getFacesContext().getExternalContext().getResourceAsStream(resourcePath);
			
			return StringTools.toString(resourceAsStream);
		} catch (IOException e) {
			error(e);
		} finally  {
			if (resourceAsStream != null) {
				try {
					resourceAsStream.close();
				} catch (IOException e) {
					error(e);
				}
			}
		}
		return "";
	}

	public String cpResource(String resourcePath) {
		InputStream resourceAsStream = null;
		try {
			resourceAsStream = getClass().getResourceAsStream(resourcePath);
			
			if (resourceAsStream == null) {
				return "Could not load the resource: " + resourcePath;
			}
			return StringTools.toString(resourceAsStream);
		} catch (IOException e) {
			error(e);
		} finally  {
			if (resourceAsStream != null) {
				try {
					resourceAsStream.close();
				} catch (IOException e) {
					error(e);
				}
			}
		}
		return "";
	}

	public String csvForRange(int start, int end) {
		StringBuilder builder = new StringBuilder();
		for(int i=start; i <= end; i++) {
			if (i != start) {
				builder.append(",");
			}
			builder.append(i);
		}
		return builder.toString();
	}
	
	public String getPortletDbId() {
		try {
			IURI uri = PortalSystem.getPortalSystem().acquireURI("portlet.wm_opencaf_showcase");
			if (uri instanceof IThingID) {
				return String.valueOf(((IThingID)uri).getDbID());
			}
		} catch (Throwable t) {
			error(t);
		}
		return null;
	}
	
	public String getResource() {
		return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI();
	}
	
	public String getResourcePage() {
		String resouce = getResource();
		return resouce.substring(resouce.lastIndexOf("/") + 1);
	}
} 