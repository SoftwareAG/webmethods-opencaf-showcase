package caf.war.wm_opencaf_showcase;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.sc.codec.encode.HTMLEncoder;

@ManagedBean(name="encodeBean")
@RequestScoped
public class EncodeBean extends BaseFacesBean {
	String text = null;
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String encodeText() {
		setText(HTMLEncoder.encoder().encode(getText()));
		return null;
	}
	
	public String decodeText() {
		
		setText(HTMLEncoder.encoder().decode(getText()));
		return null;
	}	
} 