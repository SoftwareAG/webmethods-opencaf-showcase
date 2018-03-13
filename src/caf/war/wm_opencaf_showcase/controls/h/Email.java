package caf.war.wm_opencaf_showcase.controls.h;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name = "email")
@SessionScoped
@ExpireWithPageFlow
public class Email extends BaseFacesBean {
	public String value;
	public String value2;
	public String value3;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}
	
	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public HashMap<String, String> getPassThroughAttributes() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("type", "email");
		map.put("placeholder", "Enter email");
		return map;
	}
}
