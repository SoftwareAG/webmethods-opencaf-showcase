package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.object.DateRange;

@ManagedBean(name="inputDateRangeBean")
@SessionScoped
@ExpireWithPageFlow
public class InputDateRange extends BaseFacesBean {
	private DateRange value1 = null;
	private DateRange value2 = null;
	private DateRange value3 = null;
	public DateRange getValue1() {
		return value1;
	}
	public void setValue1(DateRange value1) {
		this.value1 = value1;
	}
	public DateRange getValue2() {
		return value2;
	}
	public void setValue2(DateRange value2) {
		this.value2 = value2;
	}
	public DateRange getValue3() {
		return value3;
	}
	public void setValue3(DateRange value3) {
		this.value3 = value3;
	}
}
