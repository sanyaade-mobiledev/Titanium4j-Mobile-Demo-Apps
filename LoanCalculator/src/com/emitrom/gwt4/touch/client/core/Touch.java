/***********************************************************************
 * Touch.java is part of Touch4j 2.1
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * Touch4j is released under a commercial license only, which can be found at
 * http://www.emitrom.com/license/commercial
 * 
 * For licensing questions, please contact us at licensing@emitrom.com
 ***********************************************************************/
package com.emitrom.gwt4.touch.client.core;

import com.google.gwt.core.client.JavaScriptObject;

public class Touch {

    public static void init(InitHandler handler) {
        init(handler.getJsoPeer());
    }

    public static void init(TouchConfig config) {
        init(config.getJsObj());
    }

    private static native void init(JavaScriptObject handler)/*-{
		if (typeof ($wnd) != 'undefined' && typeof ($wnd.Ext) != 'undefined') {
			$wnd.Ext.setup({
				onReady : handler
			});
		}

    }-*/;

    private static native void init2(JavaScriptObject config)/*-{
		if (typeof ($wnd) != 'undefined' && typeof ($wnd.Ext) != 'undefined') {
			$wnd.Ext.setup(config);
		}

    }-*/;

}
