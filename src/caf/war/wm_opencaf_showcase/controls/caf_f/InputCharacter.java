package caf.war.wm_opencaf_showcase.controls.caf_f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputCharacterBean")
@SessionScoped
@ExpireWithPageFlow
public class InputCharacter extends BaseFacesBean {
	private Character value = 'a';

	public Character getValue() {
		return value;
	}

	public void setValue(Character value) {
		this.value = value;
	}
	
}
