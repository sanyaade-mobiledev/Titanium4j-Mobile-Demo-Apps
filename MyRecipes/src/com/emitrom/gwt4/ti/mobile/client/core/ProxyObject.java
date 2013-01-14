/***********************************************************************
 * ProxyObject.java is part of Titanium4j 2.0 Beta
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * For licensing questions, please contact us at licensing@emitrom.com
 * 
 * ------ Titanium4j is released under a commercial license only ------
 * 
 * http://www.emitrom.com/license?q=commercialLicense
 ***********************************************************************/
package com.emitrom.gwt4.ti.mobile.client.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class for wrapping a native Javascript class. <b>Note</b> : For internal
 * use only.
 */
public class ProxyObject {

    protected JavaScriptObject jsObj;

    protected ProxyObject() {
    }

    public ProxyObject(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    @SuppressWarnings("unused")
    private static ProxyObject create(JavaScriptObject obj) {
        return new ProxyObject(obj) {
        };
    }

    protected boolean isCreated() {
        return jsObj != null;
    }

    final public JavaScriptObject getJsObj() {
        return jsObj;
    }

    final public void setJsObj(JavaScriptObject jsObj) {
        this.jsObj = jsObj;
    }

    public void addProperty(String properytyName, String value) {
        JsoHelper.setAttribute(jsObj, properytyName, value);
    }

    public void addProperty(String properytyName, double value) {
        JsoHelper.setAttribute(jsObj, properytyName, value);
    }

    public void addProperty(String properytyName, ProxyObject value) {
        JsoHelper.setAttribute(jsObj, properytyName, value.getJsObj());
    }

    public String getString(String propertyName) {
        return JsoHelper.getAttribute(jsObj, propertyName);
    }

    public double getDouble(String propertyName) {
        return JsoHelper.getAttributeAsDouble(jsObj, propertyName);
    }

    public ProxyObject getObject(String propertyName) {
        JavaScriptObject obj = JsoHelper.getAttributeAsJavaScriptObject(jsObj, propertyName);
        return new ProxyObject(obj);
    }
}
