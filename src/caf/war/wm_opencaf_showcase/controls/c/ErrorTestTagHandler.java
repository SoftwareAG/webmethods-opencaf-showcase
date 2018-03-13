package caf.war.wm_opencaf_showcase.controls.c;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;

public class ErrorTestTagHandler extends TagHandler {

	public ErrorTestTagHandler(TagConfig config) {
		super(config);
	}

	/* (non-Javadoc)
	 * @see javax.faces.view.facelets.FaceletHandler#apply(javax.faces.view.facelets.FaceletContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void apply(FaceletContext faceletContext, UIComponent component) throws IOException {
		throw new RuntimeException("Error Thrown");
	}
	
	
}
