package caf.war.wm_opencaf_showcase.controls.f;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.rtl.util.FileUtil;

@ManagedBean(name="ajaxBean")
@SessionScoped
@ExpireWithPageFlow
public class AjaxBean extends BaseFacesBean{

	private String value = null;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction() {
		return doAction(0);
	}
	public String doAction(long delay) {
		if (delay > 0) {
			try {
				//slow down so we can see the progress message
				// for a bit.
				Thread.sleep(delay);
			} catch (Throwable t) {
				error(t);
			}
		}
		return null;
	}
	
	/**
	 * Listener for Ajax calls
	 */
	public void ajaxListener(javax.faces.event.AjaxBehaviorEvent event) throws javax.faces.event.AbortProcessingException {
		String componentId = event.getComponent().getClientId();
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajax submit processed for: " + componentId, null));		
	}
	
	/**
	 * Simulate a response containing the MWS login page
	 */
	public String doLoginResponse() {
		try {
			//render the login page
			URL url = new URL((String)resolveExpression("#{mwsCluster.frontEndUrl}"));
			
			FacesContext facesContext = getFacesContext();
			ExternalContext externalContext = facesContext.getExternalContext();
			externalContext.setResponseStatus(HttpServletResponse.SC_OK); //200
			OutputStream responseOutputStream = externalContext.getResponseOutputStream();
			InputStream openStream = url.openStream();
			FileUtil.copyStream(openStream, responseOutputStream);
			responseOutputStream.close();

			//skip the rest of the JSF lifecycle
			facesContext.responseComplete();
		} catch (Throwable t) {
			error(t);
		}
		return null;
	}
	
	/**
	 * Simulate a response containing the MWS maintenance page
	 */
	public String doMaintenanceResponse() {
		try {
			//render the maintenance page
			URL url = new URL((String)resolveExpression("#{mwsCluster.frontEndUrl}") + "/?shell=shell.maintenance");
			
			FacesContext facesContext = getFacesContext();
			ExternalContext externalContext = facesContext.getExternalContext();
			externalContext.setResponseStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); //503 
			OutputStream responseOutputStream = externalContext.getResponseOutputStream();
			InputStream openStream = url.openStream();
			FileUtil.copyStream(openStream, responseOutputStream);
			responseOutputStream.close();

			//skip the rest of the JSF lifecycle
			facesContext.responseComplete();
		} catch (Throwable t) {
			error(t);
		}
		return null;
	}

	/**
	 * Simulate an exception thrown
	 */
	public String doExceptionThrownResponse() {
		throw new FacesException("This exception was thrown from the custom action handler.");
	}
	
}
