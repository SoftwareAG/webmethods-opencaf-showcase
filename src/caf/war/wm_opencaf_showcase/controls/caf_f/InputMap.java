package caf.war.wm_opencaf_showcase.controls.caf_f;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputMapBean")
@SessionScoped
@ExpireWithPageFlow
public class InputMap extends BaseFacesBean {
	private Map<String,String> value = new HashMap<String, String>();
	
	public InputMap() {
		super();
		value.put("key1", "value1");
		value.put("key2", "value2");
	}

	public Map<String,String> getValue() {
		return value;
	}

	public void setValue(Map<String,String> value) {
		this.value = value;
	}
	
}
