package caf.war.wm_opencaf_showcase.controls.h;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="countryBean")
@SessionScoped
@ExpireWithPageFlow
public class CountryBean extends BaseFacesBean {
	
	public HashMap<String, String> countryMap;
	public HashMap<String, String> countryContentMap;
	public String continent;
	public String countryCode;

	public void onCountryChanged(ValueChangeEvent e) {
		String countryCode = e.getNewValue().toString();
		continent = countryContentMap.get(countryCode);
	}
	
	public HashMap<String, String> getCountryMap() {
		if(countryMap == null) {
			countryMap = new HashMap<String, String>();
			countryContentMap = new HashMap<String, String>();
			countryMap.put("USA", "usa");
			countryContentMap.put("usa", "North America");
			countryMap.put("Germany", "de");
			countryContentMap.put("de", "Europe");
			countryMap.put("Bulgaria", "bg");
			countryContentMap.put("bg", "Europe");
			countryMap.put("India", "in");
			countryContentMap.put("in", "Asia");
		}
		return countryMap;
	}

	public void setCountryMap(HashMap<String, String> countryMap) {
		this.countryMap = countryMap;
	}
	
	public HashMap<String, String> getContentMap() {
		if(countryContentMap == null) {
			getCountryMap();
		}
		return countryContentMap;
	}
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}
