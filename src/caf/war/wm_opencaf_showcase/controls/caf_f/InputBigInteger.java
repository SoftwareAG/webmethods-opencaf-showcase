package caf.war.wm_opencaf_showcase.controls.caf_f;

import java.math.BigInteger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputBigIntegerBean")
@SessionScoped
@ExpireWithPageFlow
public class InputBigInteger extends BaseFacesBean {
	private BigInteger value = new BigInteger("1");

	public BigInteger getValue() {
		return value;
	}

	public void setValue(BigInteger value) {
		this.value = value;
	}
	
}
