package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.portlet.ActionResponse;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="commandBean")
@SessionScoped
@ExpireWithPageFlow
public class Command extends BaseFacesBean {
	
	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction() {
		return doAction(0);
	}
	public String doAction(long delay) {
		try {
			//slow down so we can see the progress message
			// for a bit.
			Thread.sleep(delay);
		} catch (Throwable t) {
			error(t);
		}
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Command submit processed", null));
		return null;
	}

	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doActionWithParams() {
		String param1 = (String)resolveExpression("#{param['param1']}");
		String param2 = (String)resolveExpression("#{param['param2']}");
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
				String.format("Command param1 value was: %s", param1), null));
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
				String.format("Command param2 value was: %s", param2), null));

		//optionally, copy any of the request parameters that need to survive
		// as render parameters for portlet render request
		Object response = getFacesContext().getExternalContext().getResponse();
		if (response instanceof ActionResponse) {
			ActionResponse resp = (ActionResponse)response;
			//copy the request parameters to to render request
			resp.setRenderParameter("param1", param1);
			resp.setRenderParameter("param2", param2);
		}
		return null;
	}

}
