package caf.war.wm_opencaf_showcase.controls.caf_f;

import java.util.Arrays;
import java.util.Iterator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputIteratorBean")
@SessionScoped
@ExpireWithPageFlow
public class InputIterator extends BaseFacesBean {
	private Iterator<String> strIterator = Arrays.asList("one", "two").iterator();
	private Iterator<Integer> intIterator = Arrays.asList(1,2).iterator();

	public Iterator<String> getStrIterator() {
		return strIterator;
	}
	public void setStrIterator(Iterator<String> strIterator) {
		this.strIterator = strIterator;
	}
	public Iterator<Integer> getIntIterator() {
		return intIterator;
	}
	public void setIntIterator(Iterator<Integer> intIterator) {
		this.intIterator = intIterator;
	}
	
}
