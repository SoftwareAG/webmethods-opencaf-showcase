package caf.war.wm_opencaf_showcase.controls.f;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="attributesBean")
@SessionScoped
@ExpireWithPageFlow
public class AttributesBean extends BaseFacesBean {
	private Map<String,String> value = new HashMap<String, String>();
	
	public AttributesBean() {
		super();
		value.put("useClientSideValidation", "true");
		value.put("key2", "value2");
	}

	public Map<String,String> getValue() {
		return value;
	}

	public void setValue(Map<String,String> value) {
		this.value = value;
	}

}
