package caf.war.wm_opencaf_showcase.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.webmethods.caf.common.StringTools;
import com.webmethods.caf.faces.annotations.ClientSideScript;
import com.webmethods.caf.faces.annotations.ClientSideValidator;

/**
 * Demonstrates creating a custom server-side validator from scratch.
 */
@FacesValidator(value="caf.war.wm_opencaf_showcase.validator.custom")
// (optionally) register the equivalent client-side validator as below
@ClientSideValidator ( 
		function = "Showcase.customValidate", //validate function
		base = "wm_opencaf_showcase", //app containing the .js resources
		scripts = { //additional .js files to load into the page
			@ClientSideScript (
				resource = "/js/validators/custom.js",
				library = "validators/showcase"
			)		
		}
	)
public class CustomValidator implements Validator {

	/* (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public void validate(FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {

		if (!"hello".equals(value)) {
	        Object o = component.getAttributes().get("label");
	        if (o == null || (o instanceof String && ((String) o).length() == 0)) {
	            o = component.getValueExpression("label");
	        }
	        String label = null;
	        if (o instanceof String) {
	        	label = (String)o;
	        }

			FacesMessage msg = null;
			if (StringTools.notEmpty(label)) {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						label + " : Value must be 'hello'", //summary
						label + " : Value must be 'hello'"); //details
			} else {
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Value must be 'hello'", //summary
						"Value must be 'hello'"); //details
			}
			throw new ValidatorException(msg);
		}
	}

}
