package caf.war.wm_opencaf_showcase.controls.caf_f;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputDateTimeBean")
@SessionScoped
@ExpireWithPageFlow
public class InputDateTime extends BaseFacesBean {
	private Date value = new Date();

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}
	
}
