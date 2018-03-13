package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="messageBean")
@SessionScoped
@ExpireWithPageFlow
public class Message extends BaseFacesBean {
	
	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction() {
		UIComponent component = getFacesContext().getViewRoot().findComponent(":form:input");
		String clientId = component.getClientId(getFacesContext());

		//one global message
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Severity Message", null));
		//one message for the input control
		getFacesContext().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warn Severity Message", null));

		return null;
	}
}
