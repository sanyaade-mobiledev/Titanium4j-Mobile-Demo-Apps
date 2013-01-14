/***********************************************************************
 * BaseModel.java is part of Touch4j 2.1
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * Touch4j is released under a commercial license only, which can be found at
 * http://www.emitrom.com/license/commercial
 * 
 * For licensing questions, please contact us at licensing@emitrom.com
 ***********************************************************************/
package com.emitrom.gwt4.touch.client.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.emitrom.gwt4.touch.client.core.JsObject;
import com.emitrom.gwt4.touch.client.core.JsoHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Base class for all data to be displayed in data driven component like list,
 * Dataview.
 */

public class BaseModel extends JsObject {

    protected Map<String, Object> map = new HashMap<String, Object>();

    protected BaseModel() {
        jsObj = JsoHelper.createObject();
    }

    protected BaseModel(JavaScriptObject obj) {
        super(obj);
    }

    public <X> void set(String property, X value) {
        map.put(property, value);
        setNative(property, value);
    }

    public void set(String property, List<BaseModel> values) {
        map.put(property, values);
        JsArray<JavaScriptObject> rawValues = JsArray.createArray().cast();
        for (BaseModel model : values) {
            rawValues.push(model.getJsObj());
        }
        setNative(property, rawValues);
    }

    public native String get(String property)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.get) {
			return jso.get(property);
		} else {
			return jso[property];
		}
    }-*/;

    public Set<String> getFields() {
        return map.keySet();
    }

    private native <X> X setNative(String property, X value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

    static JsArray<JavaScriptObject> fromList(List<BaseModel> models) {
        JsArray<JavaScriptObject> values = JsArray.createArray().cast();
        for (BaseModel model : models) {
            values.push(model.getJsObj());
        }
        return values;
    }

    void update(JavaScriptObject obj) {
        jsObj = obj;
    }

    @SuppressWarnings("unchecked")
    public <X> X getFromCache(String property) {
        return (X) map.get(property);
    }

    public void set(String property, double value) {
        map.put(property, value);
        setNative(property, value);
    }

    private native void setNative(String property, double value)/*-{
		var jso = this.@com.emitrom.gwt4.touch.client.core.JsObject::jsObj;
		if (jso.set) {
			jso.set(property, value);
		} else {
			jso[property] = value;
		}
    }-*/;

}
