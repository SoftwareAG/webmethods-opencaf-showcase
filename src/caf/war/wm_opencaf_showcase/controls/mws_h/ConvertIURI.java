package caf.war.wm_opencaf_showcase.controls.mws_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.portal.system.IURI;

@ManagedBean(name="convertIURIBean")
@SessionScoped
@ExpireWithPageFlow
public class ConvertIURI {
	private IURI value;
	
	public IURI getValue() {
		return value;
	}
	public void setValue(IURI value) {
		this.value = value;
	}
	
}
