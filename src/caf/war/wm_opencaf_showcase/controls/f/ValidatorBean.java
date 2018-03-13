package caf.war.wm_opencaf_showcase.controls.f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import caf.war.wm_opencaf_showcase.validator.CustomValidator;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="validatorBean")
@SessionScoped
@ExpireWithPageFlow
public class ValidatorBean extends BaseFacesBean {

	/**
	 * Converter for binding attribute
	 */
	public javax.faces.validator.Validator getMyValidator() {
		return new CustomValidator();
	}

}
