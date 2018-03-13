package caf.war.wm_opencaf_showcase.controls.mws_h;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.event.impl.OpenAjaxEvent;

@ManagedBean(name="openajaxBean")
@SessionScoped
@ExpireWithPageFlow
public class OpenAjax extends BaseFacesBean {
	
	public String doEvent() {
		OpenAjaxEvent ev = new OpenAjaxEvent("wm_opencaf_showcase.openajax.sample", 
				new EventBody());
		ev.raise();
		return null;
	}
	
	@SuppressWarnings("serial")
	public static class EventBody implements Serializable {
		String now;
		
		public EventBody() {
			super();
			this.now = new Date().toString();
		}
		
		public String getNow() {
			return now;
		}

		public void setNow(String now) {
			this.now = now;
		}
	}
}
