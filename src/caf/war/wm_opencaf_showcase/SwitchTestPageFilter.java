package caf.war.wm_opencaf_showcase;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.faces.application.ApplicationAssociate;
import com.sun.faces.mgbean.BeanBuilder;
import com.sun.faces.mgbean.BeanManager;
import com.sun.faces.mgbean.ManagedBeanInfo.ManagedProperty;
import com.webmethods.caf.common.StringTools;
import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;

/**
 * Servlet Filter used for testing.
 * 
 * If the wmp_ta=switchPage then invalidate the session
 * to start clean state for the next test.
 */
@WebFilter(servletNames="Faces Servlet", dispatcherTypes=DispatcherType.REQUEST)
public class SwitchTestPageFilter implements Filter {

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if ("switchPage".equals(request.getParameter("wmp_ta"))) {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			//start with a clean session for each test
			HttpSession session = httpRequest.getSession(false);
			if (session != null) {
				FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
				LifecycleFactory lifecycleFactory = (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
				Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
				FacesContext facesContext = contextFactory.getFacesContext(request.getServletContext(), request, response, lifecycle);

				ApplicationAssociate applicationAssociate = (ApplicationAssociate)facesContext.getAttributes().get( "_applicationassociate");
		        if (applicationAssociate == null) {
		        	applicationAssociate = ApplicationAssociate.getInstance(facesContext.getExternalContext());
		    		facesContext.getAttributes().put( "_applicationassociate",applicationAssociate);
		        }        
		        if (applicationAssociate != null) {
		        	BeanManager beanManager = applicationAssociate.getBeanManager();
		            if (beanManager != null) {
						Enumeration<String> attributeNames = session.getAttributeNames();
						while (attributeNames.hasMoreElements()) {
							String key = attributeNames.nextElement();
			                BeanBuilder builder = beanManager.getBuilder(key);
			                if (builder != null) {
			                	String scope = builder.getScope();
			                	if ("session".equals(scope)) {
			                		Class<?> beanClass = builder.getBeanClass();
			                		boolean expireWithPageFlow = false;
			                		if (beanClass.getAnnotation(ExpireWithPageFlow.class) != null) {
			                			//this is a page flow scoped bean.
			                			expireWithPageFlow = true;
			                		} else {
			                			//no annotation, for backward compatibility, check the managed-bean properties too
			        		        	List<ManagedProperty> managedProperties = builder.getManagedBeanInfo().getManagedProperties();
			        		        	if (managedProperties != null) {
			            		        	for (ManagedProperty managedProperty : managedProperties) {
			        							if ("expireWithPageFlow".equals(managedProperty.getPropertyName())) {
			        								if ("true".equals(managedProperty.getPropertyValue())) {
			        									expireWithPageFlow = true;
			        									break;
			        								}
			        							}
			        						}
			        		        	}

			                		}
			                		
			                		if (expireWithPageFlow) {
			                			//throw it out...
			                			session.removeAttribute(key);
			                		}
			                	}
			                }
							
						}
		            }
		        }
			}

			//redirect to the same address without the switchPage request parameter
			StringBuffer requestURL = httpRequest.getRequestURL();
			//preserve the other query parameters
			String queryString = httpRequest.getQueryString();
			queryString = queryString.replaceAll("&?wmp_ta=switchPage&?", "");
			if (StringTools.notEmpty(queryString)) {
				requestURL.append("?").append(queryString);
			}
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect(requestURL.toString());
		} else {
			chain.doFilter(request, response);
		}
	}
}
