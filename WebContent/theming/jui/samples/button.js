var juiButtonify = function(container) {
	var container = $(container);
	var buttonify = function(button) {
		button.select('span').each(function(span){span.className = ''});
		button.select('span :last-child')[0].addClassName('ui-button-text');
		button.addClassName('ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only');		
	}
	if(container.type == 'button') {
		buttonify(container);
	} else {		
		container.select('button').each(buttonify);
	}
};