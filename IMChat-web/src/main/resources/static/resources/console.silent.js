// 屏蔽 console 的输出
;(function(win){
    if (!win) return;

    if (!win.console) {
        var fn = function(){};
        var props = [
            'assert', 'count', 'debug', 'dir', 'dirxml',
            'error', 'group', 'groupCollapsed', 'groupEnd',
            'info', 'log', 'profile', 'profileEnd', 'table',
            'time', 'timeEnd', 'timeStamp', 'trace', 'warn',
            '_exception'
        ];

        win.console = {};
        for (var i = 0, n = props.length; i < n; ++i) {
            win.console[props[i]] = fn;
        }
    }

})(window);
