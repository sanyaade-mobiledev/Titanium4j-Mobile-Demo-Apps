package com.emitrom.ti4j.myrecipes.client.events.handlers;

import com.emitrom.ti4j.myrecipes.client.events.JsonLoadedEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Base interface for any class that listen to asset load events
 */
public interface JsonLoadedHandler extends EventHandler {
    public void onJsonLoaded(JsonLoadedEvent event);
}
