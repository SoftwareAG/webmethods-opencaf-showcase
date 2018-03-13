package caf.war.wm_opencaf_showcase.controls.h;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.rtl.util.FileUtil;

@ManagedBean(name = "fileBean")
@SessionScoped
@ExpireWithPageFlow
public class FileBean extends BaseFacesBean {
	private Part file = null;
	private String fileContent;

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public String upload() {
		try {
			if(file != null) {				
				fileContent = FileUtil.getContentToString(file.getInputStream());
				getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Command submit processed", null));
			} else {
				getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No file was uploaded", null));
			}
		} catch (IOException e) {
			// Error handling
			error(e);
		}
		return null;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public void validateFile(FacesContext ctx, UIComponent comp, Object value) throws ValidatorException{
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part) value;
		if (file.getSize() > 1024 * 1024) {
			msgs.add(new FacesMessage("The file is larger then 1MB"));
		} else if(file.getSize() == 0) {
			msgs.add(new FacesMessage("The file cannot be empty"));		
		}
		if (!"text/plain".equals(file.getContentType())) {
			msgs.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please only upload text files", "Please only upload text files"));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}
}
