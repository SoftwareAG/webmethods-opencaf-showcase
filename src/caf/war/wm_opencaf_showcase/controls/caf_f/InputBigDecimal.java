package caf.war.wm_opencaf_showcase.controls.caf_f;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputBigDecimalBean")
@SessionScoped
@ExpireWithPageFlow
public class InputBigDecimal extends BaseFacesBean {
	private BigDecimal value = new BigDecimal("1");

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
