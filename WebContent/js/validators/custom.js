//register that we have loaded this
Library.complete("validators/showcase");

//create our stuff under the 'Showcase' namespace
// to avoid any collisions elsewhere.
var Showcase = {
		
    /**
     * Custom client-side input validate function.
     * 
     * @param id Client-side id of control to validate.
     * @param value Control value to validate.
     * @return Empty string ("") if value is valid,
     * or non-empty (localized) error message if value is not valid.
     */
	customValidate: function(id, value) {
		if ("hello" != value) {
            var label = CAF.Validator._getLabel(this, id);
            if (label) {
            	return label + " : Value must be 'hello'"; 
            } else {
    			return "Value must be 'hello'";
            }
		}
        
        return "";
    }
    
};