package caf.war.wm_opencaf_showcase.showcase;

/**
 * Main managed bean for the Showcase portlet
 */
import javax.faces.application.FacesMessage;
import javax.portlet.PortletPreferences;

import com.webmethods.caf.faces.bean.portlet.PortletAction;

public class Showcase extends com.webmethods.caf.faces.bean.BaseFacesPreferencesBean {

	private transient caf.war.wm_opencaf_showcase.Wm_opencaf_showcase wm_opencaf_showcase = null;
	/**
	 * List of portlet preference names
	 */
	public static final String[] PREFERENCES_NAMES = new String[] {
		"pref1", "targetSample"
	};
	/**
	 * Create new preferences bean with list of preference names
	 */
	public Showcase() {
		super(PREFERENCES_NAMES);
	}
	
	/**
	 * Call this method in order to persist
	 * Portlet preferences
	 */
	public void storePreferences() throws Exception {
		updatePreferences();
		PortletPreferences preferences = getPreferences();
		preferences.store();
	}

	public caf.war.wm_opencaf_showcase.Wm_opencaf_showcase getWm_opencaf_showcase()  {
		if (wm_opencaf_showcase == null) {
		    wm_opencaf_showcase = (caf.war.wm_opencaf_showcase.Wm_opencaf_showcase)resolveExpression("#{Wm_opencaf_showcase}");
		}
		return wm_opencaf_showcase;
	}

	/**
	 * The algorithm for this 'smart' preference getter is:
	 * 1) Check the Request Map (skip this step if it isn't a 'smart' preference)
	 * 2) Check the Member variable
	 * 3) Fall back to the PortletPreferences
	 */
	public String getPref1() throws Exception {
		return (String) getPreferenceValue("pref1", String.class);
	}

	/**
	 * Invoke {@link #storePreferences} to persist these changes
	 */
	public void setPref1(String pref1) throws Exception {
		setPreferenceValue("pref1", pref1);
	}
	
	/**
	 * Annotated method that can be invoked from a portlet
	 * action link.
	 */
	@PortletAction(axsrft=true)
	public String doAction1() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "doAction1 was called.", null);
		getFacesContext().addMessage(null, msg);
		return null;
	}

	/**
	 * The algorithm for this 'smart' preference getter is:
	 * 1) Check the Request Map (skip this step if it isn't a 'smart' preference)
	 * 2) Check the Member variable
	 * 3) Fall back to the PortletPreferences
	 */
	public String getTargetSample() throws Exception {
		return (String) getPreferenceValue("targetSample", String.class);
	}

	/**
	 * Invoke {@link #storePreferences} to persist these changes
	 */
	public void setTargetSample(String targetSample) throws Exception {
		setPreferenceValue("targetSample", targetSample);
	}
}