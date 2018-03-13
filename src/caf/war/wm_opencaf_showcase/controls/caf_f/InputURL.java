package caf.war.wm_opencaf_showcase.controls.caf_f;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputUrlBean")
@SessionScoped
@ExpireWithPageFlow
public class InputURL extends BaseFacesBean {
	private URL value = null;
	
	public InputURL() {
		super();
		
		try {
			value = new URL("http://www.softwareag.com");
		} catch (MalformedURLException e) {
			error(e);
		}
	}

	public URL getValue() {
		return value;
	}

	public void setValue(URL value) {
		this.value = value;
	}
	
}
