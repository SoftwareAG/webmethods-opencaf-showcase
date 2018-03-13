package caf.war.wm_opencaf_showcase.patterns;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.common.StringTools;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.ISelectItemGroupProvider;
import com.webmethods.caf.faces.data.object.TableSelectItemGroupProvider;

@ManagedBean(name="masterDetailsBean")
@SessionScoped
@ExpireWithPageFlow
public class MasterDetails extends BaseFacesBean {
	//holds the row objects for the test
	private TableRow[] rows = null;

	// Content provider for the master listbox
	private transient ISelectItemGroupProvider masterListboxProvider = null;

	//field to hold the current row object refrence from the master list
	private TableRow currentDetailsRow = null;
	
	//field to hold the id of the selected row in the master list
	private String selectedRowId = null;

	/**
	 * Action handler called to update the object used for
	 * bindings in the details panel.
	 */
	public String updateDetailsRow() {
		if (StringTools.isEmpty(getSelectedRowId())) {
			//no row is selected.
			currentDetailsRow = null;
		} else {
			TableRow[] r = getRows();
			for (TableRow tableRow : r) {
				if (selectedRowId.equals(tableRow.getId())) {
					//found the row object for the current row.  store it for use
					// in the controls of the details panel.
					currentDetailsRow = tableRow;
					break;
				}
			}
		}
		return null;
	}

	/**
	 * The object containing the data for the details panel
	 */
	public TableRow getDetailsRow() {
		return currentDetailsRow;
	}

	/**
	 * Get the provider that supplies the options for the master listbox
	 */
	public ISelectItemGroupProvider getListboxChoices() {
		if (masterListboxProvider == null) {
			masterListboxProvider = new TableSelectItemGroupProvider(getRows(), "field1", "id");
		}
		return masterListboxProvider;
	}
	

	public String getSelectedRowId() {
		return selectedRowId;
	}
	public void setSelectedRowId(String selectedRowId) {
		this.selectedRowId = selectedRowId;
	}

	/**
	 * Create some dummy data.  In a real scenario, this
	 * data would often come from some webservice call.
	 */
	public TableRow[] getRows() {
		if (rows == null) {
			rows = new TableRow[10];
			for(int i=0; i < rows.length; i++) {
				rows[i] = new TableRow();
				rows[i].setId(String.format("row%d", i));
				rows[i].setField1(String.format("field1: %d", i));
				rows[i].setField2((long)i);
			}
		}
		return rows;
	}

	/**
	 * Class used as row objects for the test
	 */
	public static class TableRow {
		private String id = null;
		private String field1 = null;
		private Long field2 = null;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getField1() {
			return field1;
		}
		public void setField1(String field1) {
			this.field1 = field1;
		}
		public Long getField2() {
			return field2;
		}
		public void setField2(Long field2) {
			this.field2 = field2;
		}
	}
}
