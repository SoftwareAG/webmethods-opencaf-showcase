package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="appletBean")
@SessionScoped
@ExpireWithPageFlow
public class Applet extends BaseFacesBean {
	public java.lang.String getUniqueID()  {
		UIComponent component = getFacesContext().getViewRoot().findComponent(":form:applet");
		return component.getClientId();
	}
	
	public String getAppSessionId() {
		return getFacesContext().getExternalContext().getSessionId(true);
	}

	/**
	 * Action handler for the file upload from the applet
	 */
	public String handleUploadedFiles() {
		HttpServletRequest request = (HttpServletRequest)getFacesContext().getExternalContext().getRequest();
		Enumeration<String> e = (Enumeration<String>)request.getAttributeNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			if(key.equalsIgnoreCase("MULTIPART_FILE_ITEMS")){
				@SuppressWarnings("unchecked")
				ArrayList<FileItem> l = (ArrayList<FileItem>)request.getAttribute(key);
				for (Iterator<FileItem> iterator = l.iterator(); iterator.hasNext();) {
					FileItem object = iterator.next();
					String msg = String.format("File was uploaded: %s", object.getName());
					getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
				}
			}
		}

		return null;
	}
}
