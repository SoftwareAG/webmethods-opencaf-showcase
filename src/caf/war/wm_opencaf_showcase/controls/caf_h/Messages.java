package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="messagesBean")
@SessionScoped
@ExpireWithPageFlow
public class Messages extends BaseFacesBean {
	
	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction() {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Severity Message", null));
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error Severity Message", null));
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal Severity Message", null));
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn Severity Message", null));

		return null;
	}
}
