/***********************************************************************
 * TableViewBaseModel.java is part of Titanium4j 2.0 Beta
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * For licensing questions, please contact us at licensing@emitrom.com
 * 
 * ------ Titanium4j is released under a commercial license only ------
 * 
 * http://www.emitrom.com/license?q=commercialLicense
 ***********************************************************************/
package com.emitrom.gwt4.ti.mobile.client.data;

import com.emitrom.gwt4.ti.mobile.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * Base class to use in a Table View You can extends this class to add custom
 * properties
 * 
 * @author Ekambi
 * 
 */
public class TableViewBaseModel extends BaseModel {

    public TableViewBaseModel() {
        jsObj = JsoHelper.createObject();
    }

    TableViewBaseModel(JavaScriptObject obj) {
        jsObj = obj;
    }

    public native String getTitle() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.title;
    }-*/;

    public native void setTitle(String value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.title = value;
    }-*/;

    public native void setHasChild(boolean value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.hasChild = value;
    }-*/;

    public native boolean hasChildren() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.hasChildren;
    }-*/;

    public native void setData(String value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.data = value;
    }-*/;

    public native String getData() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.data;
    }-*/;

    public native double getDouble(String property)/*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso[property];
    }-*/;

    public native String getString(String property)/*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso[property];
    }-*/;

}
