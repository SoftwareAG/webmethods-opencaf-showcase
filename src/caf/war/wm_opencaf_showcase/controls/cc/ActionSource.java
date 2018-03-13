package caf.war.wm_opencaf_showcase.controls.cc;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name = "actionSource")
@SessionScoped
@ExpireWithPageFlow
public class ActionSource extends BaseFacesBean implements ActionListener {
	public String value = "";
	public String myButtonValue2 = "SubmitButton2";
	public String getMyButtonValue2() {
		return myButtonValue2;
	}

	public void setMyButtonValue2(String myButtonValue2) {
		this.myButtonValue2 = myButtonValue2;
	}

	public String myButtonValue = "SubmitButton";
	public String getMyButtonValue() {
		return myButtonValue;
	}

	public void setMyButtonValue(String myButtonValue) {
		this.myButtonValue = myButtonValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String action() {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ActionSource#action() activated after value[" + this.getValue() +"]", null));
		return null;
	}
	
	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ActionSource#processAction() activated before value[" + this.getValue() + "]", null));
	} 
}
