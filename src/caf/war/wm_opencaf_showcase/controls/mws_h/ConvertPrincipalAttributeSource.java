package caf.war.wm_opencaf_showcase.controls.mws_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.data.dir.PrincipalAttributeValueSource;

@ManagedBean(name="convertPrincipalAttributeSourceBean")
@SessionScoped
@ExpireWithPageFlow
public class ConvertPrincipalAttributeSource {
	private PrincipalAttributeValueSource value;
	
	public PrincipalAttributeValueSource getValue() {
		return value;
	}
	public void setValue(PrincipalAttributeValueSource value) {
		this.value = value;
	}
	
}
