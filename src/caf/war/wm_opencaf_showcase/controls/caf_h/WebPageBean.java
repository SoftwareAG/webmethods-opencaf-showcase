/**
 * 
 */
package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseWebPageBean;

/**
 * AppNav
 */
@ManagedBean (name="webPageBean")
@SessionScoped
@ExpireWithPageFlow
public class WebPageBean extends BaseWebPageBean {
	private static final long serialVersionUID = -3717626804541273070L;

}
