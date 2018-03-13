package caf.war.wm_opencaf_showcase.controls.h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="dataTableBean")
@SessionScoped
@ExpireWithPageFlow
public class DataTable extends BaseFacesBean {
	
	private DataTableRow[] table;
	
	public DataTableRow[] getTable() {
		if(table == null) {
			table = new DataTableRow[10]; 
			for(int i=0; i < table.length; i++) {
				table[i] = new DataTableRow();
				table[i].setField1("field1: " + i);
				table[i].setField2((long)i);
			}
		}
		return table;
	}
	
	public static class DataTableRow {
		private String field1 = null;
		private Long field2 = null;
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
