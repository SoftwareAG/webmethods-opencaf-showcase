package caf.war.wm_opencaf_showcase.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Demonstrates creating a custom server-side converter from scratch.
 */
@FacesConverter(value="caf.war.wm_opencaf_showcase.converter.custom")
public class CustomConverter implements Converter {

	/**
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//convert from string to object
		if (value.startsWith("Converted: ")) {
			String strValue = value.substring(11);
			return strValue;
		} else {
			String msg = "Expected the value to start with 'Converted: '";
			FacesMessage facesMsg = new FacesMessage(msg, null);
			throw new ConverterException(facesMsg);
		}
	}

	/**
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		//convert from object to string
		return "Converted: " + value;
	}
}
