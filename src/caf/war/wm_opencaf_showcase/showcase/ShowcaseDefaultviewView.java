package caf.war.wm_opencaf_showcase.showcase;

import java.io.Writer;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.webmethods.caf.common.StringTools;
import com.webmethods.caf.faces.bean.portlet.PortletAction;
import com.webmethods.caf.portlet.IPortletURL;

/**
 * Page Bean for the showcase test portlet
 */
public class ShowcaseDefaultviewView  extends   com.webmethods.caf.faces.bean.BasePageBean {
	private static final long serialVersionUID = 1L;
	private static final String[][] INITIALIZE_PROPERTY_BINDINGS = new String[][] {
	};
	private transient caf.war.wm_opencaf_showcase.showcase.Showcase showcase = null;

	/**
	 * Initialize page
	 */
	public String initialize() {
		try {
		    resolveDataBinding(INITIALIZE_PROPERTY_BINDINGS, null, "initialize", true, false);

		} catch (Exception e) {
			error(e);
			log(e);
		}	
		return null;
	}

	public caf.war.wm_opencaf_showcase.showcase.Showcase getShowcase()  {
		if (showcase == null) {
		    showcase = (caf.war.wm_opencaf_showcase.showcase.Showcase)resolveExpression("#{Showcase}");
		}
		return showcase;
	}
	
	@PortletAction(axsrft=false)
	public String switchPage() {
		//clear out any state from the previous sample page
		resetPageFlowStorage();
		
		String targetPage = (String)getRequestParam().get("targetPage");
		if (StringTools.notEmpty(targetPage)) {
			try {
				String queryString = null;
				int indexOf = targetPage.indexOf('?');
				if (indexOf != -1) {
					queryString = targetPage.substring(indexOf + 1);
					targetPage = targetPage.substring(0, indexOf);
				}

				getShowcase().setTargetSample(StringTools.ensureLeading(targetPage, "/"));
				
				if (StringTools.notEmpty(queryString)) {
					//copy the query string params to the next request
					final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
					final String[] pairs = queryString.split("&");
					for (String pair : pairs) {
						final int idx = pair.indexOf("=");
						final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
						if (!query_pairs.containsKey(key)) {
							query_pairs.put(key, new LinkedList<String>());
						}
						final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
						query_pairs.get(key).add(value);
					}
					
					ActionResponse response = (ActionResponse)getFacesContext().getExternalContext().getResponse();
					for (Map.Entry<String,List<String>> entry : query_pairs.entrySet()) {						
						response.setRenderParameter(entry.getKey(), entry.getValue().toArray(new String[0]));
					}
				}
				//getShowcase().storePreferences();
			} catch (Exception e) {
				error(e);
			}
		}

		//copy the other request params to the next render request
		ActionResponse response = (ActionResponse)getFacesContext().getExternalContext().getResponse();
		Map<String, String> requestParameterMap = getFacesContext().getExternalContext().getRequestParameterMap();
		for (Map.Entry<String,String> entry : requestParameterMap.entrySet()) {
			if (!"targetPage".equals(entry.getKey())) {
				response.setRenderParameter(entry.getKey(), entry.getValue());
			}
		}
		//skip the rest of the lifecycle, go right to render
		getFacesContext().renderResponse();
		return null;
	}
	
	public boolean isInPortletRequest() {
		return getFacesContext().getExternalContext().getRequest() instanceof PortletRequest;
	}
	
	/**
	 * Portlet action handler that reads uploaded files and returns
	 * a JSON response containg the filenames that were uploaded.
	 */
	@PortletAction
	public String doFileUpload() {
		try {
	        ExternalContext externalContext = getFacesContext().getExternalContext();

	        FileItem fileItem = (FileItem)resolveExpression("#{inputFileBean.value}");
	        
//	        @SuppressWarnings("unchecked")
//			List<FileItem> files = (List<FileItem>) externalContext.getRequestMap().get(MultipartUtils.FILE_ITEMS);
	        
	        //process and write the JSON response.
			externalContext.setResponseContentType("application/json");
			externalContext.setResponseStatus(HttpServletResponse.SC_OK);
			externalContext.setResponseCharacterEncoding("UTF-8");
	        Writer responseOutputWriter = externalContext.getResponseOutputWriter();
	        responseOutputWriter.append("[");
	        
	        if (fileItem != null) {
	        	responseOutputWriter.append("\"")
        		.append(fileItem.getName())
        		.append("\"");
	        }
//	        Iterator<FileItem> iterator = files.iterator();
//	        while (iterator.hasNext()) {
//	        	FileItem next = iterator.next();
//	        	responseOutputWriter.append("\"")
//	        		.append(next.getName())
//	        		.append("\"");
//	        	if (iterator.hasNext()) {
//	        		responseOutputWriter.append(",\r\n");
//	        	}
//	        }
	        responseOutputWriter.append("]");
	        
	        //signal that the response was handled
	        getFacesContext().responseComplete();
		} catch (Exception e) {
			error(e);
		}
		return null;
	}

	/**
	 * Returns the href for an action url that will execute the 
	 * "doFileUpload" target action when the link is clicked.
	 */
	public String getFileUploadHref() {
		try {
			IPortletURL actionUrl = createActionUrl();
			actionUrl.clearParameters();
			actionUrl.clearState();
			
			actionUrl.setPortlet(getShowcase().getPortletURI());
			actionUrl.setTargetAction("doFileUpload");
			
			return actionUrl.toString();
		} catch (Exception e) {
			error(e);
		}
		return null;
	}

}