package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="stackPanelBean")
@SessionScoped
@ExpireWithPageFlow
public class StackPanel extends BaseFacesBean {
	private String value = "first";
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String doFirst() {
		setValue("first");
		return null;
	}
	public String doSecond() {
		setValue("second");
		return null;
	}
	public String doThird() {
		setValue("third");
		return null;
	}
}
