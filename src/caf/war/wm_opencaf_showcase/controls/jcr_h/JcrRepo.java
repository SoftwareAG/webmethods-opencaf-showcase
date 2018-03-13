package caf.war.wm_opencaf_showcase.controls.jcr_h;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesSessionBean;

@ManagedBean(name="jcrRepoBean")
@SessionScoped
@ExpireWithPageFlow
public class JcrRepo extends BaseFacesSessionBean {
	private Session session = null;
	private Node value = null;
	private List<Node> values = null;
	
	@Override
	protected void release() {
		//cleanup when this managed bean goes
		// out of scope
		if (session != null) {
			session.logout();
			session = null;
		}
	}
	
	/**
	 * Return a session that can interact
	 * with the JCR repository
	 */
	public Session getJcrSession() {
		if (session == null) {
			try {
		        InitialContext ctx = new InitialContext();
		        Context envCtx = (Context) ctx.lookup("java:comp/env");
		        Repository repo = (Repository)envCtx.lookup("jcr/repository");

		        //assumes the user is already logged into MWS
		        session = repo.login();
			} catch (Throwable t) {
				error(t);
			}
		}
		return session;
	}

	public Node getValue() {
		return value;
	}

	public void setValue(Node value) {
		this.value = value;
	}

	public List<Node> getValues() {
		return values;
	}

	public void setValues(List<Node> values) {
		this.values = values;
	}

}
