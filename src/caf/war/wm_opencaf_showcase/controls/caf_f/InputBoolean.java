package caf.war.wm_opencaf_showcase.controls.caf_f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputBooleanBean")
@SessionScoped
@ExpireWithPageFlow
public class InputBoolean extends BaseFacesBean {
	private Boolean value = true;

	public Boolean getValue() {
		return value;
	}

	public void setValue(Boolean value) {
		this.value = value;
	}
	
}
