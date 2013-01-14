/***********************************************************************
 * ActivityIndicator.java is part of Titanium4j 2.0 Beta
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * For licensing questions, please contact us at licensing@emitrom.com
 * 
 * ------ Titanium4j is released under a commercial license only ------
 * 
 * http://www.emitrom.com/license?q=commercialLicense
 ***********************************************************************/
package com.emitrom.gwt4.ti.mobile.client.ui;

import com.emitrom.gwt4.ti.mobile.client.core.ProxyObject;
import com.emitrom.gwt4.ti.mobile.client.core.handlers.EventHandler;
import com.emitrom.gwt4.ti.mobile.client.ui.interfaces.ColoredElement;
import com.emitrom.gwt4.ti.mobile.client.ui.interfaces.Displayable;
import com.emitrom.gwt4.ti.mobile.client.ui.interfaces.HasColor;
import com.emitrom.gwt4.ti.mobile.client.ui.interfaces.HasExtremum;
import com.emitrom.gwt4.ti.mobile.client.ui.interfaces.HasFont;
import com.emitrom.gwt4.ti.mobile.client.ui.interfaces.HasStyle;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Color;
import com.emitrom.gwt4.ti.mobile.client.ui.style.Font;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * An activity indicator can be used to show the progress of an operation in the
 * ui to let the user know some action is taking place.
 * <p>
 * For iPhone, the style can be set from the constants
 * com.emitrom.gwt.appcelerator
 * .mobile.client.ui.iphone.IPhone.ActivityIndicatorStyle.
 * 
 * @author Ekambi
 * 
 */
public class ActivityIndicator extends View implements HasFont, HasColor, Displayable, ColoredElement, HasStyle,
                HasExtremum {

    public ActivityIndicator() {
        jsObj = UI.createActivityIndicator();
    }

    private ActivityIndicator(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * @return The color of the message label
     */
    public native String getColor() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.color;
    }-*/;

    public void setColor(Color color) {
        setColor(color.getRgb());
    }

    public native void setColor(String value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.color = value;
    }-*/;

    /**
     * @return The font object for the activity message label
     */
    public native Font getFont() /*-{
		return jso.font;
    }-*/;

    public native void setFont(Font value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.font = value.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
    }-*/;

    /**
     * @return The activity message label text
     */
    public native String getMessage() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.message;
    }-*/;

    public native void setMessage(String value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.message = value;
    }-*/;

    /**
     * @return The activity type
     */
    public native int getType() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.type;
    }-*/;

    /**
     * @return The activity value
     */
    public native double getValue() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.value;
    }-*/;

    public native void setValue(int value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.value = value;
    }-*/;

    /**
     * @return The activity minimum value
     */
    public native double getMin() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.min;
    }-*/;

    public native void setMin(double value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.min = value;
    }-*/;

    /**
     * @return The activity maximum value
     */
    public native double getMax() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.min;
    }-*/;

    public native void setMax(double value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.max = value;
    }-*/;

    /**
     * @return The activity location
     */
    public native int getLocation() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.location;
    }-*/;

    /**
     * @return The key in the locale file to use for the message property
     */
    public native String getMessageId() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.messageid;
    }-*/;

    public native void setMessageId(String value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.messageid = value;
    }-*/;

    /**
     * @return The style constant of the activity indicator
     */
    public native int getStyle() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.style;
    }-*/;

    public native void setStyle(int value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.style = value;
    }-*/;

    /**
     * Call hide to make the activity indicator hidden and stop spinning
     */
    public native void hide() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.hide();
    }-*/;

    /**
     * Call show to make the activity indicator visible and start spinning
     */
    public native void show() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.show();
    }-*/;

    @Override
    public String getSelectedColor() {
        return null;
    }

    @Override
    public void setSelectedColor(String value) {

    }

    /**
     * @Android only Fired when the user has canceled the activity indicator
     *          dialog.
     * @param handler
     */
    public void addCancelHandler(EventHandler handler) {
        addEventHandler("cancel", handler);
    }

    public static ActivityIndicator from(ProxyObject proxy) {
        return new ActivityIndicator(proxy.getJsObj());
    }

}
