package caf.war.wm_opencaf_showcase.controls.caf_f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputByteBean")
@SessionScoped
@ExpireWithPageFlow
public class InputByte extends BaseFacesBean {
	private Byte value = (byte)130;

	public Byte getValue() {
		return value;
	}

	public void setValue(Byte value) {
		this.value = value;
	}
	
}
