package caf.war.wm_opencaf_showcase.controls.caf_h;

import java.util.Random;

import javax.el.ValueExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.webmethods.caf.faces.annotations.ExpireWithPageFlow;
import com.webmethods.caf.faces.bean.BaseFacesBean;

@ManagedBean(name="dynamicIncludeBean")
@SessionScoped
@ExpireWithPageFlow
public class DynamicInclude extends BaseFacesBean {
    
    protected static String[] COLORS = new String[] {
        "red", "green", "blue"
    };
    private static Random random = new Random(System.currentTimeMillis());
    		
    public String getRandomColor() {
    	ValueExpression ve = createValueExpression("#{requestScope['dynamicIncludeBean#randomColor']");
    	Object value = ve.getValue(getFacesContext().getELContext());
    	String color = null;
    	if (value instanceof String) {
    		color = (String)value;
    	} else {
        	color = COLORS[random.nextInt(3)];
        	ve.setValue(getFacesContext().getELContext(), color);
    	}
        return color;
    }
    
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

}
