package caf.war.wm_opencaf_showcase.controls.f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputBeanValidatorBean")
@SessionScoped
@ExpireWithPageFlow
public class InputBeanValidator extends BaseFacesBean {
	@javax.validation.constraints.Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
	private String value = null;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
