package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.common.StringTools;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.ISelectItemProvider;
import com.webmethods.caf.faces.data.object.DefaultSelectItemProvider;

@ManagedBean(name="selectInputBean")
@SessionScoped
@ExpireWithPageFlow
public class SelectInput extends BaseFacesBean {
	private String value = null;
	private String[] values = null;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public List<ISelectItemProvider> getFruitItems() {
		List<ISelectItemProvider> itemsList = new ArrayList<ISelectItemProvider>();
		String [] values = new String[] {
				"apple",
				"orange",
				"bananna",
				"strawberry",
				"kiwi",
				"grape"
		};
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			DefaultSelectItemProvider item = new DefaultSelectItemProvider(value, value);
			item.setDescription(String.format("Description of %s", value));
			if (i % 3 == 0) {
				item.setIcon("/resources/red.gif");
			} else if (i % 3 == 1) {
				item.setIcon("/resources/green.gif");
			} else {
				item.setIcon("/resources/blue.gif");
			}
			itemsList.add(item);
		}
		return itemsList;
	}
	
	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction() {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Select value submited was: " + StringTools.toString(getValues()), null));
		return null;
	}

	/**
	 * Action handler for the command control
	 * @return
	 */
	public String doAction2() {
		getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Select value submited was: " + getValue(), null));
		return null;
	}

}
