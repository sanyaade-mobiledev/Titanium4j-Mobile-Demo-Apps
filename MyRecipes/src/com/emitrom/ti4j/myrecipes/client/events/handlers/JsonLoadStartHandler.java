package com.emitrom.ti4j.myrecipes.client.events.handlers;

import com.emitrom.ti4j.myrecipes.client.events.JsonLoadStartEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * Base interface for any class that listen to the game start event
 */
public interface JsonLoadStartHandler extends EventHandler {
    public void onJsonLoadStart(JsonLoadStartEvent event);
}
