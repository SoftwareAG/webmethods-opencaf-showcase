package caf.war.wm_opencaf_showcase.controls.caf_h;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.search.BaseSearchBarPageBean;
import com.webmethods.caf.faces.component.search.SearchBar;
import com.webmethods.caf.faces.search.options.ISearchOptionsManager;
import com.webmethods.caf.faces.search.options.InMemorySearchOptionsManager;
import com.webmethods.caf.faces.search.saved.ISavedSearchProvider;
import com.webmethods.caf.faces.search.saved.InMemorySavedSearchProvider;

@ManagedBean(name="searchBean")
@SessionScoped
@ExpireWithPageFlow
public class Search extends BaseSearchBarPageBean {
	private static final long serialVersionUID = -382020462368979368L;

	@Override
	public ISavedSearchProvider getSavedSearchProvider() {
		if (fSavedSearchProvider == null) {
			//create an in-memory saved search provider for testing
			// this would be a different implementation in a real scenario
			fSavedSearchProvider = new InMemorySavedSearchProvider(getSearchQueryFactory());
		}
		return fSavedSearchProvider;
	}

	
	@Override
	public ISearchOptionsManager getSearchOptionsManager() {
		if (fSearchOptionsManager == null) {
			//create an in-memory saved options manager for testing
			// this would be a different implementation in a real scenario
			fSearchOptionsManager = new InMemorySearchOptionsManager();
		}
		return fSearchOptionsManager;
	}
	
	@Override
	public SearchBar getSearchBarControl() {
		UIComponent component = getFacesContext().getViewRoot().findComponent(":form:searchBar");
		if (component instanceof SearchBar) {
			return (SearchBar)component;
		}
		return null;
	}
	
}
