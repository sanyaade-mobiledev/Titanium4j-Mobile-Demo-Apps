/***********************************************************************
 * Node.java is part of Titanium4j 2.0 Beta
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
 * * A single node in the com.emitrom.gwt4.ti.mobile.client.xml.Document tree.
 * 
 * @author Ekambi
 * 
 */
public class Node extends EventDispatcher {

    protected Node() {
    }

    protected Node(JavaScriptObject obj) {
        jsObj = obj;
    }

    /**
     * @return The name of this node
     */
    public native String getNodeName() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.nodeName;
    }-*/;

    /**
     * @return The content (value) of this node
     */
    public native String getNodeValue() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.nodeValue;
    }-*/;

    /**
     * @return this node's type.
     */
    public native int getNodeType() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.nodeType;
    }-*/;

    /**
     * @return this node's parent node
     */
    public native Node getParentNode() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.parentNode;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * @return A {@link com.emitrom.gwt4.ti.mobile.client.xml.NodeList} of this
     *         node's children
     */
    public native NodeList getChildNodes() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.childNodes;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.NodeList::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * @return this node's first child
     */
    public native Node getFirstChild() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.firstChild;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * @return this node's last child
     */
    public native Node getLastChild() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.lastChild;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * @return jso node's previous sibling
     */
    public native Node getPreviousSibling() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.previousSibling;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * @return this node's next sibling
     */
    public native Node getNextSibling() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.nextSibling;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * @return A map of this node's attributes
     */
    public native NamedNodeMap getAttributes() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.attributes;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.NamedNodeMap::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
    }-*/;

    /**
     * @return this node's owning document
     */
    public native Document getOwnerDocument() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.ownerDocument;
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Document::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * @return The namespace uri of this node
     */
    public native String getNamespaceURI() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.namespaceURI;
    }-*/;

    /**
     * @return The namespace prefix of this node
     */
    public native String getPrefix() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.prefix;
    }-*/;

    /**
     * @return The local part of the qualified name of this node
     */
    public native String getLocalName() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.localName;
    }-*/;

    public native void setLocalName(String value) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		jso.localName = value;
    }-*/;

    /**
     * Appends the node 'newchild' as a child of this node
     * 
     * @param newChild
     *            The new node to append
     * @return The appended node
     */
    public native Node appendChild(Node newChild) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso
				.appendChild(newChild.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()());
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Returns a duplicate of this node
     * 
     * @param deep
     *            Whether or not to perform a deep copy of jso node
     * @return The appended node
     */
    public native Node cloneNode(boolean deep) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso.cloneNode(deep);
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Whether or not this node has attributes
     */
    public native boolean hasAttributes() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.hasAttributes();
    }-*/;

    /**
     * Whether or not this node has child nodes
     */
    public native boolean hasChildNodes() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.hasChildNodes();
    }-*/;

    /**
     * @param newChild
     *            The node to insert
     * @param refChild
     *            The node to insert `newChild` before
     * @return The inserted node
     */
    public native Node insertBefore(Node newChild, Node refChild) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso
				.insertBefore(
						newChild.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()(),
						refChild.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()());
    }-*/;

    /**
     * Tests whether the dom implementation supports a specific feature
     * 
     * @param feature
     *            The name of the feature
     * @param version
     *            The version number of the feature
     * @return Whether or not the feature is supported
     */
    public native boolean isSupported(String feature, String version) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.isSupported(feature, version);
    }-*/;

    /**
     * Normalizes text and attribute nodes in jso node's child hierarchy
     */
    public native void normalize() /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso.normalize();
    }-*/;

    /**
     * Removes a child node from jso node
     * 
     * @param oldChild
     *            The node to remove
     * @return The node that was removed
     */
    public native Node removeChild(Node oldChild) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		var obj = jso
				.removeChild(oldChild.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()());
		var toReturn = @com.emitrom.gwt4.ti.mobile.client.xml.Node::new(Lcom/google/gwt/core/client/JavaScriptObject;)(obj);
		return toReturn;
    }-*/;

    /**
     * Replaces the node oldchild with the node newchild
     * 
     * @param newChild
     *            The new node
     * @param oldChild
     *            The node being replaced
     */
    public native void replaceChild(Node newChild, Node oldChild) /*-{
		var jso = this.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()();
		return jso
				.replaceChild(
						newChild.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()(),
						oldChild.@com.emitrom.gwt4.ti.mobile.client.core.ProxyObject::getJsObj()());
    }-*/;

}
