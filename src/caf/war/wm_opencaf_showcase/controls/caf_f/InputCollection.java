package caf.war.wm_opencaf_showcase.controls.caf_f;

import java.util.Arrays;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputCollectionBean")
@SessionScoped
@ExpireWithPageFlow
public class InputCollection extends BaseFacesBean {
	private Collection<String> strCollection = Arrays.asList("one", "two");
	private Collection<Integer> intCollection = Arrays.asList(1,2);

	public Collection<String> getStrCollection() {
		return strCollection;
	}
	public void setStrCollection(Collection<String> strCollection) {
		this.strCollection = strCollection;
	}
	public Collection<Integer> getIntCollection() {
		return intCollection;
	}
	public void setIntCollection(Collection<Integer> intCollection) {
		this.intCollection = intCollection;
	}
	
}
