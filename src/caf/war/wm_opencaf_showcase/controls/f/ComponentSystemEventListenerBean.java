package caf.war.wm_opencaf_showcase.controls.f;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="componentSystemEventListenerBean")
@SessionScoped
@ExpireWithPageFlow
public class ComponentSystemEventListenerBean extends BaseFacesBean {

	/**
	 * Handler for ComponentSystemEventListener instances on a component
	 * @param event the event that was fired
	 * @throws javax.faces.event.AbortProcessingException
	 */
	public void listener(javax.faces.event.ComponentSystemEvent event) throws javax.faces.event.AbortProcessingException {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, String.format("%s executed for: %s", event.getClass().getSimpleName(), event.getComponent().getClientId()), null);
		getFacesContext().addMessage(null, msg);
	}

}
