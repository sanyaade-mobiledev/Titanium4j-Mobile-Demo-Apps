package com.emitrom.ti4j.myrecipes.client.events.handlers;

import com.emitrom.ti4j.myrecipes.client.events.XmlLoadStartEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Base interface for any class that listen to the game start event
 */
public interface XmlLoadStartHandler extends EventHandler {
    public void onXmlLoadStart(XmlLoadStartEvent event);
}
