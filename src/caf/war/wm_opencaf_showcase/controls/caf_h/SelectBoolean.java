package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="selectBooleanBean")
@SessionScoped
@ExpireWithPageFlow
public class SelectBoolean extends BaseFacesBean {
	private boolean value = true;
	
	public boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction() {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Boolean value submited was: " + getValue(), null));
		return null;
	}
	
}
