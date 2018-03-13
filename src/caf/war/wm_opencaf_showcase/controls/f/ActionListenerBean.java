package caf.war.wm_opencaf_showcase.controls.f;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="actionListenerBean")
@SessionScoped
@ExpireWithPageFlow
public class ActionListenerBean extends BaseFacesBean implements javax.faces.event.ActionListener {

	
	/**
	 * Action Listener for type attribute
	 */
	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Action Listener #1 executed", null);
		getFacesContext().addMessage(null, msg);
	}

	/**
	 * Action Listener for binding attribute
	 */
	public javax.faces.event.ActionListener getActionListener() {
		return new javax.faces.event.ActionListener() {
			
			@Override
			public void processAction(ActionEvent event) throws AbortProcessingException {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Action Listener #2 executed", null);
				getFacesContext().addMessage(null, msg);
			}
		};
	}

}
