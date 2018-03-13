package caf.war.wm_opencaf_showcase.controls.h;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class MyValueChangeListener implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		CountryBean country = (CountryBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("countryBean");
		country.setContinent(country.getContentMap().get(event.getNewValue().toString()));
	}

}
