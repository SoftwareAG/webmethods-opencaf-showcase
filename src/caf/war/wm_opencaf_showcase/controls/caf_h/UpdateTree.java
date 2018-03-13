package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.tree.ISelectableTreeContentProvider;
import com.webmethods.caf.faces.data.tree.object.ListTreeContentProvider;

@ManagedBean(name="updateTreeBean")
@SessionScoped
@ExpireWithPageFlow
public class UpdateTree extends BaseFacesBean {
	
	private transient ISelectableTreeContentProvider treeContentProvider = null;
	private List<TreeRow> rows = null;
	
	public List<TreeRow> getRows() {
		if (rows == null) {
			rows = new ArrayList<TreeRow>();
			TreeRow odd = new TreeRow();
			odd.setId("odd");
			odd.setField1("Odd");
			rows.add(odd);
			TreeRow even = new TreeRow();
			even.setId("even");
			even.setField1("Even");
			rows.add(even);
			
			for(int i=0; i < 10; i++) {
				TreeRow row = new TreeRow();
				row.setId(String.format("row%d", i));
				row.setField1(String.format("field1: %d",i));
				row.setField2((long)i);
				if (i % 2 == 0) {
					row.setCategory("even");
				} else {
					row.setCategory("odd");
				}
				rows.add(row);
			}
		}
		return rows;
	}
	
	public ISelectableTreeContentProvider getTreeContentProvider() {
		if (treeContentProvider == null) {
			ListTreeContentProvider provider = new ListTreeContentProvider(getRows());
			provider.setRowVariable("row");
			provider.setRowIdBinding(createValueBinding("#{row.id}"));
			provider.setRowType(TreeRow.class);
			provider.setParentIdBinding(createValueBinding("#{row.category}"));
			
			treeContentProvider = provider;
		}
		return treeContentProvider;
	}
	
	public static class TreeRow {
		private String id = null;
		private String field1 = null;
		private Long field2 = null;
		private String category = null;

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
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
	}
}
