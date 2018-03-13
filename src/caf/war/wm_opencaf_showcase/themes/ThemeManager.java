package caf.war.wm_opencaf_showcase.themes;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;
import com.webmethods.caf.faces.data.ISelectItemProvider;
import com.webmethods.caf.faces.data.object.DefaultSelectItemProvider;

@ManagedBean(name="themeManagerBean")
@SessionScoped
@ExpireWithPageFlow
public class ThemeManager extends BaseFacesBean {
	public List<ISelectItemProvider> themes;
	public String selectedTheme;
	
	public String getSelectedTheme() {
		return selectedTheme;
	}
	public void setSelectedTheme(String selectedTheme) {
		this.selectedTheme = selectedTheme;
	}

	public List<ISelectItemProvider>getThemes() {
		if(themes == null) {
			themes = new ArrayList<ISelectItemProvider>();
			String[][] staticThemes = new String[][] {
				{"JQuery UI Blue", "jui/lib/jui-blue/theme.css"}, 
				{"JQuery UI Green", "jui/lib/jui-green/theme.css"}
			};
			for(int i = 0; i < staticThemes.length; i++) {
				DefaultSelectItemProvider item = new DefaultSelectItemProvider(staticThemes[i][0], staticThemes[i][1]);
				themes.add(item);
			}
			selectedTheme = (String)themes.get(0).getValue();
		}
		return themes;
	}
	
}
