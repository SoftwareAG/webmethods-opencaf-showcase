package caf.war.wm_opencaf_showcase.patterns;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //process and write the JSON response.
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		response.setCharacterEncoding("UTF-8");
        Writer responseOutputWriter = response.getWriter();
        responseOutputWriter.append("[");
        Collection<Part> parts = request.getParts();
        Iterator<Part> iterator = parts.iterator();
        boolean wroteOneLine = false;
        while (iterator.hasNext()) {
        	Part part = iterator.next();
        	if (getSubmittedFileName(part) != null) {
            	if (wroteOneLine) {
            		responseOutputWriter.append(",\r\n");
            	}
            	responseOutputWriter.append("\"")
        			.append(getSubmittedFileName(part))
        			.append("\"");
            	wroteOneLine = true;
        	}
		}
        responseOutputWriter.append("]");
	}

	private static String getSubmittedFileName(Part filePart)
	{
	    String header = filePart.getHeader("content-disposition");
	    for(String headerPart : header.split(";"))
	    {
	        if(headerPart.trim().startsWith("filename"))
	        {
	            return headerPart.substring(headerPart.indexOf('=') + 1).trim()
	                             .replace("\"", "");
	        }
	    }
	    return null;
	}
}
