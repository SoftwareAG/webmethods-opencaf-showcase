package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.attachments.IAttachmentsProvider;
import com.webmethods.caf.faces.data.attachments.LocalTempAttachmentsProvider;

@ManagedBean(name="attachmentsBean")
@SessionScoped
@ExpireWithPageFlow
public class Attachments extends BaseFacesBean {
	
	private transient IAttachmentsProvider attachmentsProvider = null;
	
	public IAttachmentsProvider getAttachmentsProvider() {
		if (attachmentsProvider == null) {
			attachmentsProvider = new LocalTempAttachmentsProvider();
		}
		return attachmentsProvider;
	}
}
