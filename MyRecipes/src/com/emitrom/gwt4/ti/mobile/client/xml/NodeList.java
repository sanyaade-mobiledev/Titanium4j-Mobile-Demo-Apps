/***********************************************************************
 * NodeList.java is part of Titanium4j 2.0 Beta
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 * 
 * For licensing questions, please contact us at licensing@emitrom.com
 * 
 * ------ Titanium4j is released under a commercial license only ------
 * 
 * http://www.emitrom.com/license?q=commercialLicense
 ***********************************************************************/
package com.emitrom.gwt4.ti.mobile.client.xml;

import com.emitrom.gwt4.ti.mobile.client.core.events.EventDispatcher;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * * A list of {@link com.emitrom.gwt4.ti.mobile.client.xml.Node} objects. this
 * conforms to the dom level 2(http://www.w3.org/tr/dom-level-2-core/core.html)
 * definition of a dom nodelist.
 * 
 * @author Ekambi
 * 
 */
public class NodeList extends EventDispatcher {

    protected NodeList() {
    }

    protected NodeList(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * @return The length of the node list.
     */
    public native int getLength() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.length;
    }-*/;

    /**
     * Returns the {@link com.emitrom.gwt4.ti.mobile.client.xml.Element} object
     * at the specified index.
     * 
     * @param index
     *            The index of the node to retrieve. Indexing starts at 0.
     * @return The node at the index, or `null` if the index is out of bounds.
     */
    public native Element getItem(int index) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.item(index);
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Element::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

}
