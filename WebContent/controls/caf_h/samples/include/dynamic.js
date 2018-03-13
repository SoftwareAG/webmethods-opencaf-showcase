Event.waitUntilLoaded(function() {
    $('time').innerHTML = new Date(parseInt("#{dynamicIncludeBean.currentTime}"));
});