package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.io.IOException;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.fileupload.FileItem;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputFileBean")
@SessionScoped
@ExpireWithPageFlow
public class InputFile extends BaseFacesBean {
	private FileItem value = null;
	private FileItem value2 = null;
	
	public FileItem getValue() {
		return value;
	}

	public void setValue(FileItem value) {
		this.value = value;
	}

	public FileItem getValue2() {
		return value2;
	}

	public void setValue2(FileItem value2) {
		this.value2 = value2;
	}
	String content = null;
	public String getContent() {
		return content;
	}

	public void setContent(String fileContent) {
		this.content = fileContent;
	}
	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doUpload() {
		try {
			try {
				if(value != null) {				
					content = new Scanner(value.getInputStream())
					.useDelimiter("\\A").next();
				}
			} catch (IOException e) {
				// Error handling
			}
			//TODO: do something with the uploaded files here
			getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Command submit processed", null));
		} catch (Throwable t) {
			error(t);
		} finally {
			//make sure to delete the temp files that were uploaded
			if (value != null) {
				value.delete();
			}
			if (value2 != null) {
				value2.delete();
			}
		}
		
		return null;
	}

}
