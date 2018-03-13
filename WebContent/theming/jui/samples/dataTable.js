var jquiThemifyTable = function(table) {
	var table = $(table);
	table.removeClassName("caf.table");
	table.select('thead tr, tfoot tr').invoke("removeClassName", "portlet-section-footer");

	var makeRound =  function(th, position) {
		var setPadding = function(element) {
			var pt = $(element).getLayout().get('padding-top') + 5;
			var pb = $(element).getLayout().get('padding-bottom') + 5;
			$(element).setStyle('padding-top:' + pt + 'px').setStyle('padding-bottom:' + pb + 'px')
		}
		th.first().addClassName('mws-rounded-' + position + '-left');
		th.last().addClassName('mws-rounded-'+ position +'-right');
		setPadding(th.first());
		if(th.length > 1) { setPadding(th.last()) }
	}
	var top = table.select('thead tr:first-child th')
	var bottom = table.select('tfoot tr:last-child th')
	
	makeRound(top, 'top');
	makeRound(bottom, 'bottom');
}