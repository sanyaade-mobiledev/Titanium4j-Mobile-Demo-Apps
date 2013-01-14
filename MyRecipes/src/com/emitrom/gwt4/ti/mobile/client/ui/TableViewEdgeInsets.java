package com.emitrom.gwt4.ti.mobile.client.ui;

import com.emitrom.gwt4.ti.mobile.client.core.JsoHelper;
import com.emitrom.gwt4.ti.mobile.client.core.ProxyObject;

/**
 * On iOS, the parameter edgeInsets can be specified to set the distance(top,
 * bottom, right, left) that the content view is inset from the enclosing scroll
 * view of the table. For example
 * 
 * 
 */
public class TableViewEdgeInsets extends ProxyObject {

    public TableViewEdgeInsets() {
        jsObj = JsoHelper.createObject();
    }

    /**
     * Value specifying the bottom insets for the enclosing scroll view of the
     * table.
     * 
     * @param value
     */
    public void setBottom(double value) {
        JsoHelper.setAttribute(jsObj, "bottom", value);
    }

    /**
     * Value specifying the top insets for the enclosing scroll view of the
     * table.
     * 
     * @param value
     */
    public void setTop(double value) {
        JsoHelper.setAttribute(jsObj, "top", value);
    }

    /**
     * Value specifying the top insets for the enclosing scroll view of the
     * table.
     * 
     * @param value
     */
    public void setLeft(double value) {
        JsoHelper.setAttribute(jsObj, "left", value);
    }

    /**
     * Value specifying the top insets for the enclosing scroll view of the
     * table.
     * 
     * @param value
     */
    public void setRight(double value) {
        JsoHelper.setAttribute(jsObj, "right", value);
    }

}
