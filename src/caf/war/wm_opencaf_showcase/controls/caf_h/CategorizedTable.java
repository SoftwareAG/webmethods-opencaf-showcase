package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.ITableContentProvider;
import com.webmethods.caf.faces.data.object.ListTableContentProvider;

@ManagedBean(name="categorizedTableBean")
@SessionScoped
@ExpireWithPageFlow
public class CategorizedTable extends BaseFacesBean {
	
	private transient ITableContentProvider tableContentProvider = null;
	private TableRow[] rows = null;
	
	public TableRow[] getRows() {
		if (rows == null) {
			rows = new TableRow[5];
			for(int i=0; i < rows.length; i++) {
				rows[i] = new TableRow();
				rows[i].setField1("field1: " + i);
				rows[i].setField2((long)i);
				rows[i].setCategory(i % 2 == 0 ? "odd" : "even");
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
		private String category = null;
		
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
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
	}
}
