package caf.war.wm_opencaf_showcase.controls.h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name = "fakeUserBean")
@SessionScoped
@ExpireWithPageFlow
public class FakeUser extends BaseFacesBean {
	public String username = null;
	public int age;
	public String password;
	public String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String checkPassWordLength() {
		String message = "";
		if(username == null || username.length() == 0) {
			message = "A username is required";
		} else if(password == null || password.length() == 0) {
			message = "A password is required";
		} else if(password.length() < 5 || password.length() > 15) {
			message = "The password length is too " + (password.length() <= 4 ? "short." : "long.");
		}
		if(message.isEmpty()) {
			return null;
		} else {			
			getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
			return "";
		}
	}
	
	public String action() {
		return "";
	}
	
	public String doAction() {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Message from user", null));
		return "";
	}
}
