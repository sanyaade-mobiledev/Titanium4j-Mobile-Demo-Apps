package com.emitrom.ti4j.myrecipes.client.events.handlers;

import com.emitrom.ti4j.myrecipes.client.events.XmlLoadedEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Base interface for any class that listen to asset load events
 */
public interface XmlLoadedHandler extends EventHandler {
    public void onXmlLoaded(XmlLoadedEvent event);
}
