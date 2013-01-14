package com.emitrom.gwt4.ti.mobile.client.core;

import com.emitrom.gwt4.ti.mobile.client.api.API;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Help class to debug inside ti4j
 * 
 */
public class Debugger {

    private static final Debugger INSTANCE = new Debugger();
    private static boolean enableDebbing;

    public static Debugger get() {
        return INSTANCE;
    }

    private Debugger() {
        enableDebbing = true;
    }

    public void print(ProxyObject object) {
        _print(object.getJsObj());
    }

    private native void _print(JavaScriptObject obj)/*-{
		Titanium.API.info("------- Object output start ---------");
		for (property in obj) {
			Titanium.API.info(property + " : " + obj[property]);
		}
		Titanium.API.info("------- Object output end ---------");
    }-*/;

    public void info(String message) {
        if (enableDebbing) {
            API.get().info(message);
        }
    }

    public void enableDebugging(boolean value) {
        enableDebbing = value;
    }

}
