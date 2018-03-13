var juiDialogify = function(dialog, properties) { 
	CAF.model(dialog).addToggleListener(function(element){
		var dialog = $(element.id);
		if(element.way === 'show') {
			dialog.down('.caf-dialog-title').addClassName('ui-widget-header ui-dialog-titlebar ui-corner-all');
			dialog.down('.caf-dialog-title-container').removeClassName('caf-dialog-title-container');
			dialog.removeClassName('caf-dialog').removeClassName('mws-rounded-all').addClassName('ui-dialog ui-widget ui-widget-content ui-corner-all');
			dialog.select('.caf-dialog-content').each(function(element) { 
				element.removeClassName('caf-dialog-content').addClassName('ui-dialog-content ui-widget-content') 
				if(properties.minHeight) { element.setStyle('min-height:' + properties.minHeight + 'px')}
			});
		}	
	});
}