package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseViewBean;

@ManagedBean(name="importViewBean")
@SessionScoped
@ExpireWithPageFlow
public class ImportView extends BaseViewBean {
	private static final long serialVersionUID = 1026332848681063981L;

}
