/*
 * jQuery JavaScript Library v1.3.2
 * http://jquery.com/
 *
 * Copyright (c) 2009 John Resig
 * Dual licensed under the MIT and GPL licenses.
 * http://docs.jquery.com/License
 *
 * Date: 2009-02-19 17:34:21 -0500 (Thu, 19 Feb 2009)
 * Revision: 6246
 */
(function(a) {
    a.fn.extend({simulate:function(c, b) {
        return this.each(function() {
            new a.simulate(this, c, b)
        })
    }});
    a.simulate = function(d, c, b) {
        this.target = d;
        this.options = b;
        if (/^type/.test(c)) {
            this.simulateType(d, b);
            return
        }
        if (/^click/.test(c)) {
            this.simulateClick(d, b);
            return
        }
        if (/^dblclick/.test(c)) {
            this.simulateDblClick(d, b);
            return
        }
        if (/^rightclick/.test(c)) {
            this.simulateRightClick(d, b);
            return
        }
        if (/^mouse(over|out|up|down)/.test(c)) {
            this.simulateMouseEvent(d, c, b);
            return
        }
        if (/^change/.test(c)) {
            this.simulateChange(d, b);
            return
        }
        if (/^dragTo/.test(c)) {
            this.dragTo(b)
        }
    };
    a.extend(a.simulate.prototype, {simulateClick:function(c, b) {
        this.dispatchEvent(c, "mousedown", this.mouseEvent("mousedown", b));
        this.dispatchEvent(c, "mouseup", this.mouseEvent("mouseup", b));
        this.dispatchEvent(c, "click", this.mouseEvent("click", b));
        if (a.browser.msie) {
            if (a(c).attr("type") == "checkbox") {
                a(c).attr("checked", !a(c).attr("checked"))
            }
            if (a(c).attr("type") == "radio") {
                a(c).attr("checked", true)
            }
            if (a(c).attr("type") == "submit" || a(c).attr("type") == "image") {
                a(c).closest("form")[0].submit()
            }
            if (a(c).attr("type") == "reset") {
                a(c).closest("form")[0].reset()
            }
        }
    },simulateDblClick:function(c, b) {
        if (a.browser.msie) {
            this.dispatchEvent(c, "mousedown", this.mouseEvent("mousedown", b));
            this.dispatchEvent(c, "mouseup", this.mouseEvent("mouseup", b));
            this.dispatchEvent(c, "click", this.mouseEvent("click", b));
            this.dispatchEvent(c, "mouseup", this.mouseEvent("mouseup", b));
            this.dispatchEvent(c, "dblclick", this.mouseEvent("dblclick", b))
        } else {
            this.dispatchEvent(c, "mousedown", this.mouseEvent("mousedown", b));
            this.dispatchEvent(c, "mouseup", this.mouseEvent("mouseup", b));
            this.dispatchEvent(c, "click", this.mouseEvent("click", b));
            this.dispatchEvent(c, "mousedown", this.mouseEvent("mousedown", b));
            this.dispatchEvent(c, "mouseup", this.mouseEvent("mouseup", b));
            this.dispatchEvent(c, "click", this.mouseEvent("click", b));
            this.dispatchEvent(c, "dblclick", this.mouseEvent("dblclick", b))
        }
    },simulateRightClick:function(c, b) {
        this.dispatchEvent(c, "mousedown", this.mouseEvent("mousedown", b));
        this.dispatchEvent(c, "mouseup", this.mouseEvent("mouseup", b));
        this.dispatchEvent(c, "contextmenu", this.mouseEvent("contextmenu", b))
    },simulateMouseEvent:function(d, c, b) {
        this.dispatchEvent(d, c, this.mouseEvent(c, b))
    },mouseEvent:function(f, d) {
        var c;
        var g = a.extend({bubbles:true,cancelable:(f != "mousemove"),view:window,detail:0,screenX:0,screenY:0,clientX:0,clientY:0,ctrlKey:false,altKey:false,shiftKey:false,metaKey:false,button:0,relatedTarget:undefined}, d);
        var b = a(g.relatedTarget)[0];
        if (a.isFunction(document.createEvent)) {
            c = document.createEvent("MouseEvents");
            c.initMouseEvent(f, g.bubbles, g.cancelable, g.view, g.detail, g.screenX, g.screenY, g.clientX, g.clientY, g.ctrlKey, g.altKey, g.shiftKey, g.metaKey, g.button, g.relatedTarget || document.body.parentNode)
        } else {
            if (document.createEventObject) {
                c = document.createEventObject();
                a.extend(c, g);
                c.button = {0:1,1:4,2:2}[c.button] || c.button
            }
        }
        return c
    },simulateType:function(c, b) {
        this.dispatchEvent(c, "keydown", this.keyboardEvent("keydown", b));
        this.dispatchEvent(c, "keypress", this.keyboardEvent("keypress", b));
        if (a.browser.webkit) {
            this.dispatchEvent(c, "textInput", this.keyboardEvent("textInput", b))
        }
        this.dispatchEvent(c, "keyup", this.keyboardEvent("keyup", b))
    },keyboardEvent:function(d, c) {
        var b;
        var g = a.extend({bubbles:true,cancelable:true,view:window,ctrlKey:false,altKey:false,shiftKey:false,metaKey:false,keyCode:0,charCode:0}, c);
        if (/^textInput/.test(d)) {
            b = document.createEvent("TextEvent");
            b.initTextEvent(d, true, true, null, String.fromCharCode(c.charCode));
            return b
        }
        if (a.isFunction(document.createEvent)) {
            try {
                b = document.createEvent("KeyEvents");
                b.initKeyEvent(d, g.bubbles, g.cancelable, g.view, g.ctrlKey, g.altKey, g.shiftKey, g.metaKey, g.keyCode, g.charCode)
            } catch(f) {
                try {
                    b = document.createEvent("Events")
                } catch(f) {
                    b = document.createEvent("UIEvents")
                }
                b.initEvent(d, g.bubbles, g.cancelable);
                a.extend(b, {view:g.view,ctrlKey:g.ctrlKey,altKey:g.altKey,shiftKey:g.shiftKey,metaKey:g.metaKey,keyCode:g.keyCode,charCode:g.charCode})
            }
        } else {
            if (document.createEventObject) {
                b = document.createEventObject();
                a.extend(b, g)
            }
        }
        if (a.browser.msie || a.browser.opera) {
            b.keyCode = (g.charCode > 0) ? g.charCode : g.keyCode;
            b.charCode = undefined
        }
        return b
    },simulateChange:function(d, c) {
        var b;
        if (a.isFunction(document.createEvent)) {
            b = document.createEvent("HTMLEvents");
            b.initEvent("change", true, true)
        } else {
            b = document.createEventObject()
        }
        this.dispatchEvent(d, "change", b)
    },dispatchEvent:function(d, c, b) {
        if (d.dispatchEvent) {
            d.dispatchEvent(b)
        } else {
            if (d.fireEvent) {
                d.fireEvent("on" + c, b)
            }
        }
        return b
    },dragTo:function(k) {
        var c = this.findCenter(this.target);
        var b = this.findCenter(k.target);
        var h = Math.floor(c.x);
        var f = Math.floor(c.y);
        var g = Math.floor(b.x);
        var e = Math.floor(b.y);
        var j = (g - h) / 10;
        var i = (e - f) / 10;
        j = (j == 0) ? 1 : j;
        i = (i == 0) ? 1 : i;
        var d = {clientX:h,clientY:f};
        this.simulateMouseEvent(this.target, "mousedown", d);
        while ((Math.abs(g - h) > Math.abs(j)) || (Math.abs(e - f) > Math.abs(i))) {
            if (Math.abs(g - h) > Math.abs(j)) {
                h += j
            }
            if (Math.abs(e - f) > Math.abs(i)) {
                f += i
            }
            d = {clientX:h,clientY:f};
            this.simulateMouseEvent(this.target, "mousemove", h, f)
        }
        this.simulateMouseEvent(this.target, "mousemove", d);
        this.simulateMouseEvent(this.target, "mouseup", d);
        this.simulateMouseEvent(k.target, "mouseup", d)
    },findCenter:function(b) {
        var b = a(b),c = b.offset();
        return{x:c.left + b.outerWidth() / 2,y:c.top + b.outerHeight() / 2}
    }})
})(tQuery);