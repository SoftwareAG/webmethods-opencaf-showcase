package caf.war.wm_opencaf_showcase.controls.caf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="cafElFunctionsBean")
@SessionScoped
@ExpireWithPageFlow
public class ELFunctions extends BaseFacesBean {

	public String getHtml() {
		return "<div>hello</div>";
	}
	
	public String getUrl() {
		return "http://localhost:8585?hello=world&param2=value2";
	}

	public String getJsString() {
		return "Hello \"World\" with 'quotes'!";
	}
}
