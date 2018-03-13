package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.IUpdateableTableContentProvider;
import com.webmethods.caf.faces.data.object.SelectableListTableContentProvider;

@ManagedBean(name="updateTableBean")
@SessionScoped
@ExpireWithPageFlow
public class UpdateTable extends BaseFacesBean {
	
	private transient IUpdateableTableContentProvider tableContentProvider = null;
	private TableRow[] rows = null;
	
	public TableRow[] getRows() {
		if (rows == null) {
			rows = new TableRow[10];
			for(int i=0; i < rows.length; i++) {
				rows[i] = new TableRow();
				rows[i].setId(String.format("%d", i));
				rows[i].setField1(String.format("field1: %d",i));
				rows[i].setField2((long)i);
			}
		}
		return rows;
	}
	
	public IUpdateableTableContentProvider getTableContentProvider() {
		if (tableContentProvider == null) {
			SelectableListTableContentProvider provider = new SelectableListTableContentProvider();
			provider.setRowVariable("row");
			provider.setRowIdBinding(createValueBinding("#{row.id}"));
			provider.setRowType(TableRow.class);
			provider.setArray(getRows());
			tableContentProvider = provider;
		}
		return tableContentProvider;
	}
	
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
