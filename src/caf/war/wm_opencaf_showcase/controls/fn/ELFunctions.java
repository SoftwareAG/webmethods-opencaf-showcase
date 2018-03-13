package caf.war.wm_opencaf_showcase.controls.fn;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="fnElFunctionsBean")
@SessionScoped
@ExpireWithPageFlow
public class ELFunctions extends BaseFacesBean {

	public String [] getArrayToJoin() {
		return new String [] {
				"One",
				"Two",
				"Three"
		};
	}
	
	public String getXmlString() {
		return "<myxml>tag</myxml>";
	}

}
