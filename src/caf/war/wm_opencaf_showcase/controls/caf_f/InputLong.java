package caf.war.wm_opencaf_showcase.controls.caf_f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputLongBean")
@SessionScoped
@ExpireWithPageFlow
public class InputLong extends BaseFacesBean {
	private Long value = 1L;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
}
