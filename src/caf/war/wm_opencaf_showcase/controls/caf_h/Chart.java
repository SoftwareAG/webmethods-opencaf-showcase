package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.object.ListTableContentProvider;

@ManagedBean(name="chartBean")
@SessionScoped
@ExpireWithPageFlow
public class Chart extends BaseFacesBean {
	protected Object[] dataSource = {
			new Object[] { "Bob", 22},
			new Object[] { "Jack",43},
			new Object[] { "Jill",10},
			new Object[] { "Jim", 31},
			new Object[] { "James",12}
			};

	private java.util.List<java.lang.Object> sourceList = null;
	private com.webmethods.caf.faces.data.object.ListTableContentProvider sourceListProvider = null;

	/**
	 * Data for the chart
	 */
	public java.util.List<java.lang.Object> getSourceList()  {
		if (sourceList == null) {
			sourceList = new java.util.ArrayList<java.lang.Object>();
			for (int i = 0; i < dataSource.length; i++) {
				sourceList.add(dataSource[i]);
			}
		}
		return sourceList;
	}

	public com.webmethods.caf.faces.data.object.ListTableContentProvider getSourceListProvider()  {
		if (sourceListProvider == null) {
			sourceListProvider = new ListTableContentProvider(getSourceList());
		}
		return sourceListProvider;
	}

	/**
	 * Action handler for a click on a chart column
	 */ 
	public String doAction() {
		String testParamValue = (String)resolveExpression("#{param.TestParam}");
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
				String.format("doAction processed for: %s", testParamValue), null));
		return null;
	}

}
