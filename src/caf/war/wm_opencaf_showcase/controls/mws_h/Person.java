package caf.war.wm_opencaf_showcase.controls.mws_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.dir.UserModel;

@ManagedBean(name="personBean")
@SessionScoped
@ExpireWithPageFlow
public class Person extends BaseFacesBean {
	private UserModel userModel = null;
	
	public UserModel getCurrentUser() {
		if (userModel == null) {
			userModel = new UserModel();
		}
		return userModel;
	}
		
}
