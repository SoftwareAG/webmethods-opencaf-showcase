package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputDateBean")
@SessionScoped
@ExpireWithPageFlow
public class InputDate extends BaseFacesBean {
	private Date value = null;
	
	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}
}
