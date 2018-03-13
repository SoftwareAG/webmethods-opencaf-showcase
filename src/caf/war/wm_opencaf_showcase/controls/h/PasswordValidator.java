package caf.war.wm_opencaf_showcase.controls.h;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("password.equals")
public class PasswordValidator implements javax.faces.validator.Validator {
	
	@Override
	public void validate(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
		String confirmPassword = (String)value;
		UIInput otherInput = (UIInput) context.getViewRoot().findComponent(":form:pwd");
		String password = (String)otherInput.getValue();
		if(!confirmPassword.equals(password)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords do not match!", "Passwords do not match!");
			throw new ValidatorException(msg);
		}
	}
}
