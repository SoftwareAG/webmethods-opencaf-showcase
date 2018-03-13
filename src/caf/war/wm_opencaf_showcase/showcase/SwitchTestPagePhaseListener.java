/**
 * 
 */
package caf.war.wm_opencaf_showcase.showcase;

import java.util.Map;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.webmethods.caf.faces.portlet.PageFlowScopeStorage;

/**
 * Listens for switching the test page and resets the pageflow storage
 * so each test starts with clean state.
 */
public class SwitchTestPagePhaseListener implements PhaseListener {

	private static final long serialVersionUID = 2025817288992906804L;

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#afterPhase(javax.faces.event.PhaseEvent)
	 */
	@Override
	public void afterPhase(PhaseEvent e) {
		//no-op
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 */
	@Override
	public void beforePhase(PhaseEvent e) {
		String targetAction = (String) e.getFacesContext().getExternalContext().getRequestMap().get("wmp_ta");
		if ("switchPage".equals(targetAction)) {
			//reset the pageflow storage
	        Map<?, ?> sessionMap = e.getFacesContext().getExternalContext().getSessionMap();
	        PageFlowScopeStorage pageFlowScopeStorage = (PageFlowScopeStorage) sessionMap.get(PageFlowScopeStorage.SESSION_ATTR);
	        if (pageFlowScopeStorage != null) {
	        	pageFlowScopeStorage.release();
	        }
		}
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#getPhaseId()
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
