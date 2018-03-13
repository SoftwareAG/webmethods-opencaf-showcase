package caf.war.wm_opencaf_showcase.controls.f;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import caf.war.wm_opencaf_showcase.converter.CustomConverter;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="converterBean")
@SessionScoped
@ExpireWithPageFlow
public class ConverterBean extends BaseFacesBean {

	/**
	 * Converter for binding attribute
	 */
	public javax.faces.convert.Converter getMyConverter() {
		return new CustomConverter();
	}

}
