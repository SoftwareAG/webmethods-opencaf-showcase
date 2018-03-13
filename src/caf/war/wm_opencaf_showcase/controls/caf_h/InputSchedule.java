package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.object.Schedule;

@ManagedBean(name="inputScheduleBean")
@SessionScoped
@ExpireWithPageFlow
public class InputSchedule extends BaseFacesBean {
	private Schedule value = null;
	
	public Schedule getValue() {
		return value;
	}

	public void setValue(Schedule value) {
		this.value = value;
	}
}
