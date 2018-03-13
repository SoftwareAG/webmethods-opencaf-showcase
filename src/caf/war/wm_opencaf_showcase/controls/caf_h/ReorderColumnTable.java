package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.ITableContentProvider;
import com.webmethods.caf.faces.data.object.ListTableContentProvider;
import com.webmethods.rtl.util.StringTools;

@ManagedBean(name="reorderColumnTableBean")
@SessionScoped
@ExpireWithPageFlow
public class ReorderColumnTable extends BaseFacesBean {
	
	private transient ITableContentProvider tableContentProvider = null;
	private TableRow[] rows = null;

	private String[] columnIds = null;
	
	
	public String[] getColumnIds() {
		return columnIds;
	}

	public void setColumnIds(String[] columnIds) {
		this.columnIds = columnIds;
	}

	public String storeColumnOrder() {
		error(FacesMessage.SEVERITY_INFO, "storeColumnOrder called for: " + StringTools.toCsv(getColumnIds()), null);
		//TODO: store the columnIds somewhere to use later.
		return null;
	}
		
	public TableRow[] getRows() {
		if (rows == null) {
			rows = new TableRow[10];
			for(int i=0; i < rows.length; i++) {
				rows[i] = new TableRow();
				rows[i].setField1("field1: " + i);
				rows[i].setField2((long)i);
			}
		}
		return rows;
	}
	
	public ITableContentProvider getTableContentProvider() {
		if (tableContentProvider == null) {
			tableContentProvider = new ListTableContentProvider(getRows());
			tableContentProvider.setRowVariable("rows");
		}
		return tableContentProvider;
	}
	
	public static class TableRow {
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
