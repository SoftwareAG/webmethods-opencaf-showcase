package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.io.IOException;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="inputDragAndDropFileBean")
@SessionScoped
@ExpireWithPageFlow
public class InputDragAndDropFile extends BaseFacesBean {
	private Part value = null;
	private List<Part> value2 = null;
	
	public Part getValue() {
		return value;
	}

	public void setValue(Part value) {
		this.value = value;
	}

	public List<Part> getValue2() {
		return value2;
	}

	public void setValue2(List<Part> value2) {
		this.value2 = value2;
	}

	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doUpload() {
		try {
			if (value == null) {
				String msg = "Server did not recieve any file";
				getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
			} else {
				String msg = String.format("Server recieved file: %s", value.getSubmittedFileName());
				getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
			}
		} catch (Throwable t) {
			error(t);
		} finally {
			//make sure to delete the temp files that were uploaded
			if (value != null) {
				try {
					value.delete();
				} catch (IOException e) {
					error(e);
				}
			}
			if (value2 != null) {
				for (Part part : value2) {
					try {
						part.delete();
					} catch (IOException e) {
						error(e);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doUpload2() {
		try {
			if (value2 == null) {
				String msg = "Server did not recieve any files";
				getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
			} else {
				StringBuilder filenamesCsv = new StringBuilder();
				for (Part part: value2) {
					if (filenamesCsv.length() > 0) {
						filenamesCsv.append(", ");
					}
					filenamesCsv.append(part.getSubmittedFileName());
				}
				
				String msg = String.format("Server recieved files: %s", filenamesCsv);
				getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
			}
		} catch (Throwable t) {
			error(t);
		} finally {
			//make sure to delete the temp files that were uploaded
			if (value != null) {
				try {
					value.delete();
				} catch (IOException e) {
					error(e);
				}
			}
			if (value2 != null) {
				for (Part part : value2) {
					try {
						part.delete();
					} catch (IOException e) {
						error(e);
					}
				}
			}
		}
		return null;
	}

	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doUpload3() {
		throw new FacesException("Error thrown from the serverside action handler");
	}
}
