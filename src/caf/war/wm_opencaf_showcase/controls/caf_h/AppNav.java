/**
 * 
 */
package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.nav.xml.XMLAppNavBean;

/**
 * AppNav
 */
@ManagedBean (name="appNavBean")
@SessionScoped
@ExpireWithPageFlow
public class AppNav extends XMLAppNavBean {

	public AppNav() {
		super("/WEB-INF/app-nav.xml");
	}

}
