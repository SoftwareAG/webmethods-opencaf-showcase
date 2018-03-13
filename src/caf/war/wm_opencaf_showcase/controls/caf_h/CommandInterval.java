package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="commandIntervalBean")
@SessionScoped
@ExpireWithPageFlow
public class CommandInterval extends BaseFacesBean {
	private int intervalCount = 0;
	
	public int getIntervalCount() {
		return intervalCount;
	}

	public void setIntervalCount(int intervalCount) {
		this.intervalCount = intervalCount;
	}

	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction() {
		try {
			//slow down so we can see the progress message
			// for a bit.
			Thread.sleep(2000);
		} catch (Throwable t) {
			error(t);
		}
		
		//increment the counter
		setIntervalCount(getIntervalCount() + 1);
		
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Command submit processed, intervalCount = " + getIntervalCount(), null));
		return null;
	}
}
