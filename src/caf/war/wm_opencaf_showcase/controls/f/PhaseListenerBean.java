package caf.war.wm_opencaf_showcase.controls.f;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="phaseListenerBean")
@SessionScoped
@ExpireWithPageFlow
public class PhaseListenerBean extends BaseFacesBean implements PhaseListener {
	private static final long serialVersionUID = 1L;

	/**
	 * Phase Listener for type attribute
	 */
	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	/**
	 * Phase Listener for type attribute
	 */
	@Override
	public void beforePhase(PhaseEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Phase Listener #1 beforePhase executed: " + event.getPhaseId(), null);
		getFacesContext().addMessage(null, msg);
	}


	/**
	 * Phase Listener for type attribute
	 */
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Phase Listener #1 afterPhase executed: " + event.getPhaseId(), null);
		getFacesContext().addMessage(null, msg);
	}

	/**
	 * Phase Listener for binding attribute
	 */
	public PhaseListener getPhaseListener() {
		return new PhaseListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public PhaseId getPhaseId() {
				return PhaseId.ANY_PHASE;
			}
			
			@Override
			public void beforePhase(PhaseEvent event) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Phase Listener #2 beforePhase executed: " + event.getPhaseId(), null);
				getFacesContext().addMessage(null, msg);
			}
			
			@Override
			public void afterPhase(PhaseEvent event) {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Phase Listener #2 afterPhase executed: " + event.getPhaseId(), null);
				getFacesContext().addMessage(null, msg);
			}
		};
	}

}
