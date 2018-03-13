package caf.war.wm_opencaf_showcase.controls.mws_h;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.softwareag.caf.controls.mwsx.PeopleSearchBar;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.search.BaseSearchBarPageBean;
import com.webmethods.caf.faces.component.search.SearchBar;
import com.webmethods.caf.faces.component.search.view.SearchBarControlBean;
import com.webmethods.caf.faces.component.util.ComponentUtils;
import com.webmethods.caf.faces.search.options.ISearchOptionsManager;
import com.webmethods.caf.faces.search.options.InMemorySearchOptionsManager;
import com.webmethods.caf.faces.search.query.ISearchQuery;
import com.webmethods.caf.faces.search.saved.ISavedSearchProvider;
import com.webmethods.caf.faces.search.saved.InMemorySavedSearchProvider;

@ManagedBean(name="peopleSearchBean")
@SessionScoped
@ExpireWithPageFlow
public class PeopleSearch extends BaseSearchBarPageBean {
	private static final long serialVersionUID = -382020462368979368L;

	private String [] people;
	private String person;
	private ISearchQuery activeSearchQuery = null;
	
	public String[] getPeople() {
		return people;
	}

	public void setPeople(String[] people) {
		this.people = people;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String doCustomGo(String searchBarId) {
		FacesContext fc = getFacesContext();
		UIComponent searchBarComponent = ComponentUtils.findComponent(fc, fc.getViewRoot(), searchBarId);
		if (searchBarComponent instanceof PeopleSearchBar) {
			//do the original logic
			SearchBarControlBean controlBean = ((PeopleSearchBar)searchBarComponent).getControlBean();
			controlBean.constructSearchQueryString();

			//update our active search query field with the new query information.
			Map<String, Object> searchOptions = controlBean.getSearchOptionsManager().getSearchOptions();
			String lastSearchState = (String)searchOptions.get(ISearchOptionsManager.KEY_LAST_SEARCH_STATE);
			activeSearchQuery = getSearchQueryFactory().createSearchQuery(lastSearchState);
		}
		return null;
	}
	
	public ISearchQuery getActiveSearchQuery() {
		return activeSearchQuery;
	}

	public void setActiveSearchQuery(ISearchQuery activeSearchQuery) {
		this.activeSearchQuery = activeSearchQuery;
	}

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
