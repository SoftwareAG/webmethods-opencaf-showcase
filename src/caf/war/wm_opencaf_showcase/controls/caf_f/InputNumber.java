package caf.war.wm_opencaf_showcase.controls.caf_f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputNumberBean")
@SessionScoped
@ExpireWithPageFlow
public class InputNumber extends BaseFacesBean {
	private Number value = 1L;

	public Number getValue() {
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}
	
}
