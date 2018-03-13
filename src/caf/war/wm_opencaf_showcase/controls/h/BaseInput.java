package caf.war.wm_opencaf_showcase.controls.h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name = "baseInputBean")
@SessionScoped
@ExpireWithPageFlow
public class BaseInput extends BaseFacesBean {
	private String multiLineValue = "Hello World\nHow are you?";
	private String simpleValue = "Hello World";
	private String emptyValue = "";

	public String getSimpleValue() {
		return simpleValue;
	}

	public void setSimpleValue(String value) {
		this.simpleValue = value;
	}

	public String getEmptyValue() {
		return emptyValue;
	}

	public void setEmptyValue(String emptyValue) {
		this.emptyValue = emptyValue;
	}

	public String getMultiLineValue() {
		return multiLineValue;
	}

	public void setMultiLineValue(String multiLineValue) {
		this.multiLineValue = multiLineValue;
	}
}
