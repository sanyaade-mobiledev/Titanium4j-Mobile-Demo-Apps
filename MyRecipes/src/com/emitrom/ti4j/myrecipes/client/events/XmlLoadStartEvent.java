package com.emitrom.ti4j.myrecipes.client.events;

import com.emitrom.ti4j.myrecipes.client.events.handlers.XmlLoadStartHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Dispatched when an asset is loaded
 * 
 */
public class XmlLoadStartEvent extends GwtEvent<XmlLoadStartHandler> {

    public static Type<XmlLoadStartHandler> TYPE = new Type<XmlLoadStartHandler>();

    @Override
    public Type<XmlLoadStartHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(XmlLoadStartHandler handler) {
        handler.onXmlLoadStart(this);
    }

}
