package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="dialogBean")
@SessionScoped
@ExpireWithPageFlow
public class Dialog extends BaseFacesBean {
	
	/**
	 * Action handler for the dialog submit button
	 * @return
	 */
	public String doSubmitAction() {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dialog submit processed", null));
		return null;
	}
	
	
	/**
	 * Action handler for the dialog2 toggle button
	 * @return
	 */
	public String doPrepareDialog2() {
		//reset any dialog state here
		UIComponent dialog2 = getFacesContext().getViewRoot().findComponent(":form:dialog2");
		getFacesContext().addMessage(dialog2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_INFO, "Dialog2 prepared", null));
		return null;
	}
	
	/**
	 * Action handler for the dialog2 error button
	 * @return
	 */
	public String doSubmitActionError() {
		UIComponent dialog2 = getFacesContext().getViewRoot().findComponent(":form:dialog2");
		getFacesContext().addMessage(dialog2.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Dialog2 action error", null));
		return null;
	}

	/**
	 * Action handler for the dialog2 success button
	 * @return
	 */
	public String doSubmitActionSuccess() {
		//add the success flag to the 'flash' state
		getFacesContext().getExternalContext().getFlash().put("dialog2_submitSuccess", Boolean.TRUE);
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dialog2 submit processed", null));
		return null;
	}
}
